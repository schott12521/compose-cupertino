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

val CupertinoIcons.Outlined.CheckmarkMessage: ImageVector
    get() {
        if (_checkmarkMessage != null) {
            return _checkmarkMessage!!
        }
        _checkmarkMessage =
            Builder(
                name = "CheckmarkMessage",
                defaultWidth = 26.5781.dp,
                defaultHeight = 24.5508.dp,
                viewportWidth = 26.5781f,
                viewportHeight =
                24.5508f,
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
                    curveTo(26.5781f, 4.7578f, 20.6719f, 0.0f, 13.2891f, 0.0f)
                    curveTo(5.9063f, 0.0f, 0.0f, 4.7578f, 0.0f, 10.6523f)
                    curveTo(0.0f, 14.4961f, 2.4609f, 17.9062f, 6.1641f, 19.6172f)
                    curveTo(5.6367f, 20.6367f, 4.6523f, 22.0195f, 4.125f, 22.7109f)
                    curveTo(3.5039f, 23.5312f, 3.8789f, 24.5508f, 5.0859f, 24.5508f)
                    close()
                    moveTo(6.3164f, 22.6055f)
                    curveTo(6.2227f, 22.6406f, 6.1875f, 22.5703f, 6.2461f, 22.4883f)
                    curveTo(6.9023f, 21.6797f, 7.8398f, 20.4609f, 8.2383f, 19.7109f)
                    curveTo(8.5664f, 19.1016f, 8.4844f, 18.5625f, 7.7344f, 18.2109f)
                    curveTo(4.0547f, 16.5f, 1.9453f, 13.7695f, 1.9453f, 10.6523f)
                    curveTo(1.9453f, 5.8477f, 6.9727f, 1.9336f, 13.2891f, 1.9336f)
                    curveTo(19.6172f, 1.9336f, 24.6445f, 5.8477f, 24.6445f, 10.6523f)
                    curveTo(24.6445f, 15.4453f, 19.6172f, 19.3594f, 13.2891f, 19.3594f)
                    curveTo(13.0547f, 19.3594f, 12.6914f, 19.3477f, 12.2227f, 19.3359f)
                    curveTo(11.7305f, 19.3359f, 11.3555f, 19.4883f, 10.9102f, 19.8398f)
                    curveTo(9.4688f, 20.8828f, 7.3828f, 22.1719f, 6.3164f, 22.6055f)
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
                    moveTo(12.0117f, 16.3242f)
                    curveTo(12.3984f, 16.3242f, 12.7266f, 16.1367f, 12.9609f, 15.7852f)
                    lineTo(18.3164f, 7.3477f)
                    curveTo(18.4453f, 7.125f, 18.5977f, 6.8555f, 18.5977f, 6.5977f)
                    curveTo(18.5977f, 6.082f, 18.1289f, 5.7422f, 17.6484f, 5.7422f)
                    curveTo(17.3438f, 5.7422f, 17.0508f, 5.918f, 16.8281f, 6.2695f)
                    lineTo(11.9648f, 14.0742f)
                    lineTo(9.6563f, 11.0859f)
                    curveTo(9.375f, 10.7109f, 9.1172f, 10.6055f, 8.8008f, 10.6055f)
                    curveTo(8.2852f, 10.6055f, 7.8867f, 11.0156f, 7.8867f, 11.543f)
                    curveTo(7.8867f, 11.7891f, 7.9922f, 12.0469f, 8.1563f, 12.2695f)
                    lineTo(11.0156f, 15.7852f)
                    curveTo(11.3086f, 16.1719f, 11.625f, 16.3242f, 12.0117f, 16.3242f)
                    close()
                }
            }.build()
        return _checkmarkMessage!!
    }

private var _checkmarkMessage: ImageVector? = null
