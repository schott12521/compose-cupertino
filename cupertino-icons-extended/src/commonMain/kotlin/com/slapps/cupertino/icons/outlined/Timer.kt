

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

val CupertinoIcons.Outlined.Timer: ImageVector
    get() {
        if (_timer != null) {
            return _timer!!
        }
        _timer =
            Builder(
                name = "Timer",
                defaultWidth = 23.9062.dp,
                defaultHeight = 23.918.dp,
                viewportWidth = 23.9062f,
                viewportHeight = 23.918f,
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
                    moveTo(11.9531f, 23.9062f)
                    curveTo(18.4922f, 23.9062f, 23.9062f, 18.4805f, 23.9062f, 11.9531f)
                    curveTo(23.9062f, 5.4141f, 18.5039f, 0.0f, 11.9648f, 0.0f)
                    curveTo(11.3438f, 0.0f, 11.0391f, 0.375f, 11.0391f, 0.9844f)
                    lineTo(11.0391f, 5.5195f)
                    curveTo(11.0391f, 6.0352f, 11.3906f, 6.4336f, 11.8945f, 6.4336f)
                    curveTo(12.4102f, 6.4336f, 12.7617f, 6.0352f, 12.7617f, 5.5195f)
                    lineTo(12.7617f, 0.9609f)
                    lineTo(11.9414f, 1.9922f)
                    curveTo(17.4961f, 1.9922f, 21.9023f, 6.4219f, 21.9023f, 11.9531f)
                    curveTo(21.9023f, 17.4844f, 17.4844f, 21.9141f, 11.9531f, 21.9141f)
                    curveTo(6.4219f, 21.9141f, 1.9805f, 17.4844f, 1.9922f, 11.9531f)
                    curveTo(2.0039f, 9.4805f, 2.8828f, 7.2422f, 4.3594f, 5.5195f)
                    curveTo(4.7109f, 5.0625f, 4.7344f, 4.5117f, 4.3477f, 4.1016f)
                    curveTo(3.9609f, 3.6914f, 3.3164f, 3.7266f, 2.8828f, 4.2422f)
                    curveTo(1.1016f, 6.3281f, 0.0f, 9.0352f, 0.0f, 11.9531f)
                    curveTo(0.0f, 18.4805f, 5.4258f, 23.9062f, 11.9531f, 23.9062f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero,
                ) {
                    moveTo(13.8281f, 13.6406f)
                    curveTo(14.7539f, 12.668f, 14.5664f, 11.3672f, 13.4531f, 10.5938f)
                    lineTo(7.2539f, 6.2578f)
                    curveTo(6.668f, 5.8477f, 6.0586f, 6.4688f, 6.4688f, 7.043f)
                    lineTo(10.793f, 13.2422f)
                    curveTo(11.5781f, 14.3555f, 12.8789f, 14.5547f, 13.8281f, 13.6406f)
                    close()
                }
            }.build()
        return _timer!!
    }

private var _timer: ImageVector? = null
