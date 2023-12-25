package com.example.canvasclock.presentation.main_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.canvasclock.ui.theme.AnalogClockHourHandColor
import com.example.canvasclock.ui.theme.AnalogClockInnerBoxColor
import com.example.canvasclock.ui.theme.AnalogClockInnerBoxShadow
import com.example.canvasclock.ui.theme.AnalogClockMinuteHandColor
import com.example.canvasclock.ui.theme.AnalogClockOuterBoxColor
import com.example.canvasclock.ui.theme.AnalogClockOuterBoxShadow1
import com.example.canvasclock.ui.theme.AnalogClockOuterBoxShadow2
import com.example.canvasclock.ui.theme.AnalogClockOuterBoxShadow3
import com.example.canvasclock.ui.theme.AnalogClockOuterBoxShadow4
import com.example.canvasclock.ui.theme.AnalogClockSecondHandColor
import com.example.canvasclock.util.shadow
import kotlin.math.min

@Composable
fun AnalogClockComponent(
    hour: Int,
    minute: Int,
    second: Int
) {
    Box(
        modifier = Modifier
            .fillMaxSize(fraction = .75f)
            .aspectRatio(1f)
            .shadow(
                offsetX = (-38).dp,
                offsetY = 0.dp,
                blurRadios = 44.dp,
                color = AnalogClockOuterBoxShadow1
            )
            .shadow(
                offsetX = 20.dp,
                offsetY = 30.dp,
                blurRadios = 14.dp,
                color = AnalogClockOuterBoxShadow2
            )
            .shadow(
                offsetX = (-11).dp,
                offsetY = 0.dp,
                blurRadios = 44.dp,
                color = AnalogClockOuterBoxShadow3
            )
            .shadow(
                offsetX = 10.dp,
                offsetY = 0.dp,
                blurRadios = 74.dp,
                color = AnalogClockOuterBoxShadow4
            )
            .clip(CircleShape)
            .background(color = AnalogClockInnerBoxColor),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(fraction = .8f)
                .aspectRatio(1f)
                .shadow(
                    offsetX = 4.dp,
                    offsetY = 0.dp,
                    blurRadios = 10.dp,
                    color = AnalogClockInnerBoxShadow
                )
                .clip(CircleShape)
                .background(color = AnalogClockOuterBoxColor)
        ) {
            Canvas(
                modifier = Modifier.fillMaxSize()
            ) {
                val diameter = min(size.width, size.height) * 0.9f
                val radius = diameter / 2



                repeat(4) {
                    val start = center - Offset(0f, radius)
                    val end = start + Offset(0f, radius / 40f)

                    rotate(it / 4f * 360) {
                        drawLine(
                            color = Color.Black,
                            start = start,
                            end = end,
                            strokeWidth = 5.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }
                }

                val secondRatio = second / 60f
                val minuteRatio = minute / 60f
                val hourRatio = hour / 60f

                rotate(hourRatio * 360, center) {
                    drawLine(
                        color = AnalogClockHourHandColor,
                        start = center - Offset(0f, radius * 0.4f),
                        end = center + Offset(0f, radius * 0.1f),
                        strokeWidth = 3.8.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                rotate(minuteRatio * 360, center) {
                    drawLine(
                        color = AnalogClockMinuteHandColor,
                        start = center - Offset(0f, radius * 0.6f),
                        end = center + Offset(0f, radius * 0.13f),
                        strokeWidth = 3.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                rotate(secondRatio * 360, center) {
                    drawLine(
                        color = AnalogClockSecondHandColor,
                        start = center - Offset(0f, radius * 0.8f),
                        end = center + Offset(0f, radius * 0.2f),
                        strokeWidth = 3.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                drawCircle(
                    color = AnalogClockSecondHandColor,
                    radius = 5.dp.toPx(),
                    center = center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnalogClockComponent(
            "0".toInt(),
            "50".toInt(),
            "10".toInt()
        )
    }
}