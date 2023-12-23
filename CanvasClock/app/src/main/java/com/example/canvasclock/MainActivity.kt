package com.example.canvasclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.canvasclock.presentation.main_screen.MainScreen
import com.example.canvasclock.ui.theme.CanvasClockTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasClockTheme(
                dynamicColor = false
            ) {
                MainScreen()
            }
        }
    }
}