/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.github.alexzhirkevich.cupertino.icons.filled

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

val CupertinoIcons.Filled.ShieldLefthalfed: ImageVector
    get() {
        if (_shieldLefthalfed != null) {
            return _shieldLefthalfed!!
        }
        _shieldLefthalfed = Builder(name = "ShieldLefthalfed", defaultWidth = 19.4766.dp,
                defaultHeight = 24.293.dp, viewportWidth = 19.4766f, viewportHeight =
                24.293f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 14.4609f)
                curveTo(0.0f, 18.7383f, 2.2969f, 20.3086f, 8.9531f, 24.0586f)
                curveTo(9.2578f, 24.2227f, 9.5508f, 24.293f, 9.7383f, 24.293f)
                curveTo(9.9258f, 24.293f, 10.2305f, 24.2227f, 10.5234f, 24.0586f)
                curveTo(17.1914f, 20.3203f, 19.4766f, 18.7383f, 19.4766f, 14.4609f)
                lineTo(19.4766f, 5.4961f)
                curveTo(19.4766f, 4.2656f, 18.9492f, 3.8789f, 17.9531f, 3.457f)
                curveTo(16.5703f, 2.8828f, 12.1055f, 1.2773f, 10.7227f, 0.7969f)
                curveTo(10.4062f, 0.6914f, 10.0664f, 0.6211f, 9.7383f, 0.6211f)
                curveTo(9.4102f, 0.6211f, 9.0703f, 0.7148f, 8.7656f, 0.7969f)
                curveTo(7.3828f, 1.1953f, 2.9063f, 2.8945f, 1.5234f, 3.457f)
                curveTo(0.5391f, 3.8672f, 0.0f, 4.2656f, 0.0f, 5.4961f)
                close()
                moveTo(9.9844f, 22.125f)
                lineTo(9.9844f, 2.543f)
                curveTo(10.043f, 2.5547f, 10.1133f, 2.5781f, 10.207f, 2.6133f)
                curveTo(11.9766f, 3.3164f, 15.4102f, 4.5586f, 17.2266f, 5.1797f)
                curveTo(17.543f, 5.2969f, 17.6133f, 5.4609f, 17.6133f, 5.8594f)
                lineTo(17.6133f, 14.0273f)
                curveTo(17.6133f, 17.6484f, 15.8789f, 18.5977f, 10.4648f, 21.8906f)
                curveTo(10.2891f, 22.0078f, 10.125f, 22.0898f, 9.9844f, 22.125f)
                close()
            }
        }
        .build()
        return _shieldLefthalfed!!
    }

private var _shieldLefthalfed: ImageVector? = null
