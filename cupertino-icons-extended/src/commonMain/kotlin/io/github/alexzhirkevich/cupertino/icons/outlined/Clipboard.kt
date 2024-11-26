

package io.github.alexzhirkevich.cupertino.icons.outlined

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.cupertino.icons.CupertinoIcons

val CupertinoIcons.Outlined.Clipboard: ImageVector
    get() {
        if (_clipboard != null) {
            return _clipboard!!
        }
        _clipboard = Builder(name = "Clipboard", defaultWidth = 19.7109.dp, defaultHeight =
                29.7539.dp, viewportWidth = 19.7109f, viewportHeight = 29.7539f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.6328f, 28.3945f)
                lineTo(16.0781f, 28.3945f)
                curveTo(18.5039f, 28.3945f, 19.7109f, 27.1758f, 19.7109f, 24.7148f)
                lineTo(19.7109f, 6.9492f)
                curveTo(19.7109f, 4.5469f, 18.5508f, 3.2695f, 16.207f, 3.2695f)
                lineTo(15.9258f, 3.2695f)
                curveTo(15.9375f, 3.3633f, 15.9375f, 3.4688f, 15.9375f, 3.5625f)
                lineTo(15.9375f, 4.6172f)
                curveTo(15.9375f, 4.8047f, 15.9258f, 4.9922f, 15.8906f, 5.1563f)
                lineTo(16.1719f, 5.1563f)
                curveTo(17.2734f, 5.1563f, 17.8242f, 5.8711f, 17.8242f, 6.9727f)
                lineTo(17.8242f, 24.6914f)
                curveTo(17.8242f, 25.8633f, 17.2031f, 26.5078f, 15.9844f, 26.5078f)
                lineTo(3.7266f, 26.5078f)
                curveTo(2.5078f, 26.5078f, 1.8867f, 25.8633f, 1.8867f, 24.6914f)
                lineTo(1.8867f, 6.9727f)
                curveTo(1.8867f, 5.8711f, 2.4375f, 5.1563f, 3.5391f, 5.1563f)
                lineTo(3.8203f, 5.1563f)
                curveTo(3.7852f, 4.9922f, 3.7734f, 4.8047f, 3.7734f, 4.6172f)
                lineTo(3.7734f, 3.5625f)
                curveTo(3.7734f, 3.4688f, 3.7734f, 3.3633f, 3.7852f, 3.2695f)
                lineTo(3.5039f, 3.2695f)
                curveTo(1.1602f, 3.2695f, 0.0f, 4.5469f, 0.0f, 6.9492f)
                lineTo(0.0f, 24.7148f)
                curveTo(0.0f, 27.1758f, 1.207f, 28.3945f, 3.6328f, 28.3945f)
                close()
                moveTo(6.2344f, 5.9531f)
                lineTo(13.4766f, 5.9531f)
                curveTo(14.1562f, 5.9531f, 14.5664f, 5.5195f, 14.5664f, 4.793f)
                lineTo(14.5664f, 3.5625f)
                curveTo(14.5664f, 2.8359f, 14.1562f, 2.4023f, 13.4766f, 2.4023f)
                lineTo(12.3984f, 2.4023f)
                curveTo(12.3164f, 1.0781f, 11.2148f, 0.0f, 9.8555f, 0.0f)
                curveTo(8.4961f, 0.0f, 7.3945f, 1.0781f, 7.3125f, 2.4023f)
                lineTo(6.2344f, 2.4023f)
                curveTo(5.5547f, 2.4023f, 5.1445f, 2.8359f, 5.1445f, 3.5625f)
                lineTo(5.1445f, 4.793f)
                curveTo(5.1445f, 5.5195f, 5.5547f, 5.9531f, 6.2344f, 5.9531f)
                close()
                moveTo(9.8555f, 3.5156f)
                curveTo(9.293f, 3.5156f, 8.8359f, 3.0469f, 8.8359f, 2.4961f)
                curveTo(8.8359f, 1.9219f, 9.293f, 1.4648f, 9.8555f, 1.4648f)
                curveTo(10.418f, 1.4648f, 10.875f, 1.9219f, 10.875f, 2.4961f)
                curveTo(10.875f, 3.0469f, 10.418f, 3.5156f, 9.8555f, 3.5156f)
                close()
            }
        }
        .build()
        return _clipboard!!
    }

private var _clipboard: ImageVector? = null
