

package com.slapps.cupertino.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import com.slapps.cupertino.InternalCupertinoApi

@Stable
class Shapes(
    val extraSmall: CornerBasedShape = ShapeDefaults.ExtraSmall,
    val small: CornerBasedShape = ShapeDefaults.Small,
    val medium: CornerBasedShape = ShapeDefaults.Medium,
    val large: CornerBasedShape = ShapeDefaults.Large,
    val extraLarge: CornerBasedShape = ShapeDefaults.ExtraLarge,
) {
    fun copy(
        extraSmall: CornerBasedShape = this.extraSmall,
        small: CornerBasedShape = this.small,
        medium: CornerBasedShape = this.medium,
        large: CornerBasedShape = this.large,
        extraLarge: CornerBasedShape = this.extraLarge,
    ) = Shapes(
        extraSmall = extraSmall,
        small = small,
        medium = medium,
        large = large,
        extraLarge = extraLarge,
    )
}

@InternalCupertinoApi
val LocalShapes = staticCompositionLocalOf { Shapes() }

@Immutable
object ShapeDefaults {
    /** Extra small sized corner shape */
    val ExtraSmall: CornerBasedShape = RoundedCornerShape(4.dp)

    /** Small sized corner shape */
    val Small: CornerBasedShape = RoundedCornerShape(8.dp)

    /** Medium sized corner shape */
    val Medium: CornerBasedShape = RoundedCornerShape(12.dp)

    /** Large sized corner shape */
    val Large: CornerBasedShape = RoundedCornerShape(16.dp)

    /** Extra large sized corner shape */
    val ExtraLarge: CornerBasedShape = RoundedCornerShape(24.dp)
}
