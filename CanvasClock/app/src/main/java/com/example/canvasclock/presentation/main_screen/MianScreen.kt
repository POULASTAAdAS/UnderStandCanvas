package com.example.canvasclock.presentation.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.canvasclock.presentation.main_screen.components.AnalogClockComponent
import com.example.canvasclock.presentation.main_screen.components.DigitalClockComponent
import com.example.canvasclock.presentation.main_screen.components.HeaderComponent

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(fraction = .8f),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            HeaderComponent()


            AnalogClockComponent(
                hour = viewModel.hour.value.toInt(),
                minute = viewModel.minute.value.toInt(),
                second = viewModel.second.value.toInt()
            )
            DigitalClockComponent(
                hour = viewModel.hour.value,
                minute = viewModel.minute.value,
                second = viewModel.second.value,
                amOrPm = viewModel.amOrPm.value
            )
        }
    }
}