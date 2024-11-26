

package io.github.alexzhirkevich.cupertino

import platform.UIKit.UIAccessibilityDarkerSystemColorsEnabled
import platform.UIKit.UIAccessibilityIsReduceTransparencyEnabled

actual val Accessibility.isHighContrastEnabled : Boolean
    get() = UIAccessibilityDarkerSystemColorsEnabled()

actual val Accessibility.isReduceTransparencyEnabled : Boolean
    get() = UIAccessibilityIsReduceTransparencyEnabled()