

package io.github.alexzhirkevich.cupertino.section

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

enum class SectionStyle(
    val inset: Boolean,
    val grouped: Boolean,
) {
    Sidebar(true, true),
    InsetGrouped(true, true),
    Grouped(false, true),
    Inset(true, false),
    Plain(false, false),
}

/**
 * Style of the [section]s and [CupertinoSection]s. Defaults to [SectionStyle.InsetGrouped].
 *
 * Can be used to provide the same style for all sections on page / in application.
 * */
val LocalSectionStyle =
    compositionLocalOf {
        SectionStyle.InsetGrouped
    }

@Composable
fun ProvideSectionStyle(
    style: SectionStyle,
    content: @Composable () -> Unit,
) = CompositionLocalProvider(LocalSectionStyle provides style, content = content)

/**
 * Apply this to section title.
 * It will automatically [uppercase] text if needed
 * */
@Composable
fun String.sectionTitle(style: SectionStyle = LocalSectionStyle.current) = if (style.shouldCapsTitle) uppercase() else this

/**
 * Apply this modifier to the section container.
 * It will automatically set required background
 * */
fun Modifier.sectionContainerBackground(style: SectionStyle? = null) =
    composed {
        background(
            CupertinoSectionDefaults
                .containerColor(style ?: LocalSectionStyle.current),
        )
    }

internal val SectionStyle.shouldCapsTitle
    get() = this != SectionStyle.Sidebar && grouped

internal val SectionStyle.shouldFillContainer
    get() = !grouped
