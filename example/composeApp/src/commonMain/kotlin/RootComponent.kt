

import adaptive.AdaptiveWidgetsComponent
import adaptive.DefaultAdaptiveWidgetsComponent
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackDispatcher
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import cupertino.CupertinoWidgetsComponent
import cupertino.DefaultCupertinoWidgetsComponent
import icons.DefaultIconsComponent
import icons.IconsComponent
import com.slapps.cupertino.theme.CupertinoColors
import com.slapps.cupertino.theme.systemBlue
import kotlinx.serialization.Serializable
import sections.DefaultSectionsComponent
import sections.SectionsComponent

interface RootComponent : ComponentContext {
    val stack: Value<ChildStack<*, Child>>

    val accentColor: State<Pair<Color, Color>>

    val isInvertLayoutDirection: State<Boolean>

    val isDark: State<Boolean>

    val isMaterial: State<Boolean>

    val backDispatcher: BackDispatcher

    fun onBack()

    sealed interface Child {
        class Cupertino(
            val component: CupertinoWidgetsComponent,
        ) : Child

        class Adaptive(
            val component: AdaptiveWidgetsComponent,
        ) : Child

        class Icons(
            val component: IconsComponent,
        ) : Child

        class Sections(
            val component: SectionsComponent,
        ) : Child
    }
}

class RootViewModel : InstanceKeeper.Instance {
    val accentColors =
        mutableStateOf(
            CupertinoColors.systemBlue(false) to CupertinoColors.systemBlue(true),
        )

    val invertLayoutDirection = mutableStateOf(false)

    val isDark = mutableStateOf(false)

    val isMaterial = mutableStateOf(false)
}

class DefaultRootComponent(
    context: ComponentContext,
) : RootComponent,
    ComponentContext by context {
    private val navigation = StackNavigation<Config>()

    private val model =
        instanceKeeper.getOrCreate {
            RootViewModel()
        }

    override val accentColor: State<Pair<Color, Color>>
        get() = model.accentColors

    override val isInvertLayoutDirection: State<Boolean>
        get() = model.invertLayoutDirection

    override val isDark: State<Boolean>
        get() = model.isDark

    override val isMaterial: State<Boolean>
        get() = model.isMaterial

    override val backDispatcher: BackDispatcher =
        (backHandler as? BackDispatcher)
            ?: BackDispatcher()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Cupertino,
            handleBackButton = true,
            childFactory = ::child,
        )

    override fun onBack() {
        navigation.pop()
    }

    private fun child(
        config: Config,
        context: ComponentContext,
    ): RootComponent.Child =
        when (config) {
            Config.Adaptive ->
                RootComponent.Child.Adaptive(
                    DefaultAdaptiveWidgetsComponent(
                        context = context,
                        onNavigateBack = this::onBack,
                        isMaterial = model.isMaterial,
                    ),
                )

            Config.Cupertino ->
                RootComponent.Child.Cupertino(
                    DefaultCupertinoWidgetsComponent(
                        context = context,
                        onAccentColorChanged = { light, dark ->
                            model.accentColors.value = light to dark
                        },
                        onNavigate = {
                            val screen =
                                when (it) {
                                    RootComponent.Child.Adaptive::class -> Config.Adaptive
                                    RootComponent.Child.Icons::class -> Config.Icons
                                    RootComponent.Child.Sections::class -> Config.Sections
                                    else -> return@DefaultCupertinoWidgetsComponent
                                }
                            navigation.push(screen)
                        },
                        dark = model.isDark,
                        invertLayoutDirection = model.invertLayoutDirection,
                    ),
                )

            Config.Icons ->
                RootComponent.Child.Icons(
                    DefaultIconsComponent(
                        context = context,
                        onNavigateBack = this::onBack,
                    ),
                )

            Config.Sections ->
                RootComponent.Child.Sections(
                    DefaultSectionsComponent(
                        context = context,
                        onNavigateBack = this::onBack,
                    ),
                )
        }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Cupertino : Config

        @Serializable
        data object Adaptive : Config

        @Serializable
        data object Icons : Config

        @Serializable
        data object Sections : Config
    }
}
