package com.example.canvasclock.presentation.main_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun DigitalClockComponent(
    hour: String,
    minute: String,
    second: String = "00",
    amOrPm: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$hour:$minute:$second $amOrPm",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 3.sp
        )
        Text(
            text = "Kolkata , India",
            style = MaterialTheme.typography.bodyMedium.merge(
                TextStyle(
                    color = MaterialTheme.colorScheme.onBackground.copy(
                        alpha = .6f
                    )
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column {
        DigitalClockComponent(
            hour = "10",
            minute = "10",
            amOrPm = "AM"
        )
    }
}