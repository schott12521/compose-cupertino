

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

val CupertinoIcons.Outlined.BoltHorizontal: ImageVector
    get() {
        if (_boltHorizontal != null) {
            return _boltHorizontal!!
        }
        _boltHorizontal = Builder(name = "BoltHorizontal", defaultWidth = 32.2991.dp, defaultHeight
                = 15.5039.dp, viewportWidth = 32.2991f, viewportHeight = 15.5039f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.4001f, 12.7383f)
                curveTo(-0.7132f, 14.168f, 0.7165f, 15.3281f, 2.0056f, 14.5781f)
                lineTo(10.5017f, 9.7266f)
                lineTo(20.5798f, 15.1289f)
                curveTo(21.0486f, 15.3633f, 21.447f, 15.5039f, 21.8337f, 15.5039f)
                curveTo(22.3728f, 15.5039f, 22.865f, 15.2578f, 23.3337f, 14.6602f)
                lineTo(31.9587f, 3.7617f)
                curveTo(32.8962f, 2.5781f, 31.7478f, 1.1133f, 30.3298f, 1.9102f)
                lineTo(21.8337f, 6.7969f)
                lineTo(11.7439f, 1.3945f)
                curveTo(11.2868f, 1.1367f, 10.865f, 1.0195f, 10.49f, 1.0195f)
                curveTo(9.9392f, 1.0195f, 9.4704f, 1.2656f, 9.0017f, 1.8633f)
                close()
                moveTo(3.0603f, 12.2812f)
                curveTo(2.9197f, 12.3516f, 2.8493f, 12.2344f, 2.9431f, 12.1289f)
                lineTo(10.3611f, 3.1406f)
                curveTo(10.5251f, 2.9297f, 10.6775f, 2.9063f, 10.9001f, 3.0234f)
                lineTo(21.4118f, 8.6367f)
                curveTo(21.904f, 8.8945f, 22.0564f, 8.8242f, 22.4431f, 8.5781f)
                lineTo(29.3103f, 4.207f)
                curveTo(29.4157f, 4.1367f, 29.5329f, 4.2539f, 29.4392f, 4.3594f)
                lineTo(21.9861f, 13.3828f)
                curveTo(21.822f, 13.582f, 21.6579f, 13.6172f, 21.447f, 13.5f)
                lineTo(10.9236f, 7.8867f)
                curveTo(10.4314f, 7.6289f, 10.279f, 7.6875f, 9.8923f, 7.9336f)
                close()
            }
        }
        .build()
        return _boltHorizontal!!
    }

private var _boltHorizontal: ImageVector? = null
