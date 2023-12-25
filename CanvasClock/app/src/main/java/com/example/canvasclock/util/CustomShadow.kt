package com.example.canvasclock.util

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.shadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadios: Dp = 0.dp
) = then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadios != 0.dp)
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadios.toPx(), BlurMaskFilter.Blur.NORMAL))
            frameworkPaint.color = color.toArgb()

            canvas.drawCircle(
                center = Offset(
                    x = center.x + offsetY.toPx(),
                    y = center.y + offsetX.toPx()
                ),
                radius = size.width / 2,
                paint = paint
            )
        }
    }
)