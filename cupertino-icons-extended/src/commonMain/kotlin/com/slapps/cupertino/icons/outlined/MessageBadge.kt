

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

val CupertinoIcons.Outlined.MessageBadge: ImageVector
    get() {
        if (_messageBadge != null) {
            return _messageBadge!!
        }
        _messageBadge =
            Builder(
                name = "MessageBadge",
                defaultWidth = 26.5781.dp,
                defaultHeight =
                    24.5508.dp,
                viewportWidth = 26.5781f,
                viewportHeight = 24.5508f,
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
                    moveTo(5.0859f, 24.5508f)
                    curveTo(6.668f, 24.5508f, 9.9023f, 22.957f, 12.2812f, 21.2578f)
                    curveTo(20.4492f, 21.4805f, 26.5781f, 16.793f, 26.5781f, 10.6523f)
                    curveTo(26.5781f, 9.8438f, 26.4609f, 9.0586f, 26.2383f, 8.3203f)
                    curveTo(25.7227f, 8.7773f, 25.125f, 9.1289f, 24.4805f, 9.3516f)
                    curveTo(24.5859f, 9.7734f, 24.6445f, 10.207f, 24.6445f, 10.6523f)
                    curveTo(24.6445f, 15.4453f, 19.6172f, 19.3594f, 13.2891f, 19.3594f)
                    curveTo(13.0547f, 19.3594f, 12.6914f, 19.3477f, 12.2227f, 19.3359f)
                    curveTo(11.7305f, 19.3359f, 11.3555f, 19.4883f, 10.9102f, 19.8398f)
                    curveTo(9.4688f, 20.8828f, 7.3828f, 22.1719f, 6.3164f, 22.6055f)
                    curveTo(6.2227f, 22.6406f, 6.1875f, 22.5703f, 6.2461f, 22.4883f)
                    curveTo(6.9023f, 21.6797f, 7.8398f, 20.4609f, 8.2383f, 19.7109f)
                    curveTo(8.5664f, 19.1016f, 8.4844f, 18.5625f, 7.7344f, 18.2109f)
                    curveTo(4.0547f, 16.5f, 1.9453f, 13.7695f, 1.9453f, 10.6523f)
                    curveTo(1.9453f, 5.8477f, 6.9727f, 1.9336f, 13.2891f, 1.9336f)
                    curveTo(14.6367f, 1.9336f, 15.9258f, 2.1094f, 17.1094f, 2.4609f)
                    curveTo(17.2969f, 1.8047f, 17.5781f, 1.207f, 17.9883f, 0.6914f)
                    curveTo(16.5352f, 0.2461f, 14.9414f, 0.0f, 13.2891f, 0.0f)
                    curveTo(5.9063f, 0.0f, 0.0f, 4.7578f, 0.0f, 10.6523f)
                    curveTo(0.0f, 14.4961f, 2.4609f, 17.9062f, 6.1641f, 19.6172f)
                    curveTo(5.6367f, 20.6367f, 4.6523f, 22.0195f, 4.125f, 22.7109f)
                    curveTo(3.5039f, 23.5312f, 3.8789f, 24.5508f, 5.0859f, 24.5508f)
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
                    moveTo(22.5234f, 8.1211f)
                    curveTo(24.7383f, 8.1211f, 26.5781f, 6.293f, 26.5781f, 4.0547f)
                    curveTo(26.5781f, 1.8281f, 24.7383f, 0.0f, 22.5234f, 0.0f)
                    curveTo(20.2852f, 0.0f, 18.457f, 1.8281f, 18.457f, 4.0547f)
                    curveTo(18.457f, 6.293f, 20.2852f, 8.1211f, 22.5234f, 8.1211f)
                    close()
                }
            }.build()
        return _messageBadge!!
    }

private var _messageBadge: ImageVector? = null
