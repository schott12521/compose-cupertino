

package com.slapps.cupertino.icons.outlined

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.slapps.cupertino.icons.CupertinoIcons

val CupertinoIcons.Outlined.Info: ImageVector
    get() {
        if (_info != null) {
            return _info!!
        }
        _info =
            Builder(
                name = "Info",
                defaultWidth = 9.48047.dp,
                defaultHeight = 19.6055.dp,
                viewportWidth = 9.48047f,
                viewportHeight = 19.6055f,
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero,
                ) {
                    moveTo(0.0f, 17.1914f)
                    curveTo(0.0f, 17.7656f, 0.4102f, 18.1523f, 1.0313f, 18.1523f)
                    lineTo(8.4492f, 18.1523f)
                    curveTo(9.0703f, 18.1523f, 9.4805f, 17.7656f, 9.4805f, 17.1914f)
                    curveTo(9.4805f, 16.6289f, 9.0703f, 16.2422f, 8.4492f, 16.2422f)
                    lineTo(6.0938f, 16.2422f)
                    lineTo(6.0938f, 7.3008f)
                    curveTo(6.0938f, 6.668f, 5.6836f, 6.2461f, 5.0742f, 6.2461f)
                    lineTo(1.3594f, 6.2461f)
                    curveTo(0.75f, 6.2461f, 0.3281f, 6.6211f, 0.3281f, 7.1836f)
                    curveTo(0.3281f, 7.7695f, 0.75f, 8.1563f, 1.3594f, 8.1563f)
                    lineTo(3.9258f, 8.1563f)
                    lineTo(3.9258f, 16.2422f)
                    lineTo(1.0313f, 16.2422f)
                    curveTo(0.4102f, 16.2422f, 0.0f, 16.6289f, 0.0f, 17.1914f)
                    close()
                    moveTo(2.9063f, 1.6992f)
                    curveTo(2.9063f, 2.6367f, 3.6563f, 3.3867f, 4.5938f, 3.3867f)
                    curveTo(5.543f, 3.3867f, 6.2695f, 2.6367f, 6.2695f, 1.6992f)
                    curveTo(6.2695f, 0.75f, 5.543f, 0.0f, 4.5938f, 0.0f)
                    curveTo(3.6563f, 0.0f, 2.9063f, 0.75f, 2.9063f, 1.6992f)
                    close()
                }
            }.build()
        return _info!!
    }

private var _info: ImageVector? = null
