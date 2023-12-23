package com.example.canvasclock.presentation.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.canvasclock.presentation.main_screen.components.AnalogClockComponent
import com.example.canvasclock.presentation.main_screen.components.DigitalClockComponent
import com.example.canvasclock.presentation.main_screen.components.HeaderComponent
import com.example.canvasclock.presentation.main_screen.components.NavigationBarComponent

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    Scaffold(
        bottomBar = {
            NavigationBarComponent()
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderComponent(it)

                Box(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight(fraction = .8f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        AnalogClockComponent()
                        DigitalClockComponent(
                            hour = viewModel.hour.value,
                            minute = viewModel.minute.value,
                            second = viewModel.second.value,
                            amOrPm = viewModel.amOrPm.value
                        )
                    }
                }
            }
        }
    }
}