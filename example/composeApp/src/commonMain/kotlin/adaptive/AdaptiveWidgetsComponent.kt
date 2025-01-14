/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 * Copyright (c) 2025. Scott Lanoue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package adaptive

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import com.arkivanov.decompose.ComponentContext

/*
 * Copyright (c) 2023 Compose Cupertino project and open source contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

interface AdaptiveWidgetsComponent {
    val isMaterial: State<Boolean>

    fun onThemeChanged()

    fun onNavigateBack()
}

class DefaultAdaptiveWidgetsComponent(
    context: ComponentContext,
    private val onNavigateBack: () -> Unit,
    override val isMaterial: MutableState<Boolean>,
) : AdaptiveWidgetsComponent,
    ComponentContext by context {
    override fun onNavigateBack() {
        onNavigateBack.invoke()
    }

    override fun onThemeChanged() {
        isMaterial.value = !isMaterial.value
    }
}
