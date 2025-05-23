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



package com.slapps.cupertino.icons.filled

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

val CupertinoIcons.Filled.Flag2Crossed: ImageVector
    get() {
        if (_flag2Crossed != null) {
            return _flag2Crossed!!
        }
        _flag2Crossed =
            Builder(
                name = "Flag2Crossed",
                defaultWidth = 41.8572.dp,
                defaultHeight =
                    24.2974.dp,
                viewportWidth = 41.8572f,
                viewportHeight = 24.2974f,
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
                    moveTo(21.7384f, 10.0335f)
                    lineTo(22.7579f, 11.7913f)
                    lineTo(23.168f, 11.0764f)
                    curveTo(23.7188f, 11.2874f, 24.5743f, 11.5803f, 25.5352f, 12.1194f)
                    curveTo(28.3712f, 13.7717f, 29.4845f, 16.3733f, 32.4141f, 18.0725f)
                    curveTo(33.2579f, 18.5764f, 34.172f, 18.9397f, 34.8634f, 19.0217f)
                    curveTo(35.7071f, 19.1038f, 36.4454f, 18.846f, 36.9727f, 17.9319f)
                    lineTo(41.6954f, 9.7639f)
                    curveTo(42.0587f, 9.1194f, 41.7774f, 8.5335f, 41.1798f, 8.1819f)
                    curveTo(40.6641f, 7.8889f, 39.5743f, 7.6194f, 38.3321f, 6.9046f)
                    curveTo(35.4845f, 5.2639f, 34.3829f, 2.6506f, 31.4532f, 0.9514f)
                    curveTo(30.6095f, 0.4592f, 29.6837f, 0.096f, 29.004f, 0.0139f)
                    curveTo(28.1602f, -0.0681f, 27.422f, 0.2014f, 26.8946f, 1.1155f)
                    close()
                    moveTo(20.1212f, 16.3616f)
                    lineTo(19.0899f, 14.592f)
                    lineTo(14.3087f, 22.8772f)
                    curveTo(14.0626f, 23.2991f, 14.2266f, 23.8499f, 14.6368f, 24.096f)
                    curveTo(15.0704f, 24.342f, 15.5977f, 24.2014f, 15.8321f, 23.7678f)
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
                    moveTo(27.5509f, 22.8772f)
                    lineTo(14.9649f, 1.1155f)
                    curveTo(14.4376f, 0.2014f, 13.6993f, -0.0681f, 12.8555f, 0.0139f)
                    curveTo(12.1641f, 0.096f, 11.2501f, 0.4592f, 10.4063f, 0.9514f)
                    curveTo(7.4766f, 2.6506f, 6.3634f, 5.2639f, 3.5157f, 6.9046f)
                    curveTo(2.2735f, 7.6194f, 1.1954f, 7.8889f, 0.6798f, 8.1819f)
                    curveTo(0.0704f, 8.5335f, -0.1991f, 9.1194f, 0.1641f, 9.7639f)
                    lineTo(4.8751f, 17.9319f)
                    curveTo(5.4024f, 18.846f, 6.1524f, 19.1038f, 6.9844f, 19.0217f)
                    curveTo(7.6759f, 18.9397f, 8.6016f, 18.5764f, 9.4337f, 18.0725f)
                    curveTo(12.3751f, 16.3733f, 13.4766f, 13.7717f, 16.3243f, 12.1194f)
                    curveTo(17.2735f, 11.5803f, 18.1407f, 11.2874f, 18.6915f, 11.0764f)
                    lineTo(26.0157f, 23.7678f)
                    curveTo(26.2618f, 24.2014f, 26.7891f, 24.342f, 27.2227f, 24.096f)
                    curveTo(27.6329f, 23.8499f, 27.7852f, 23.2991f, 27.5509f, 22.8772f)
                    close()
                }
            }.build()
        return _flag2Crossed!!
    }

private var _flag2Crossed: ImageVector? = null
