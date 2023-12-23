package com.example.canvasclock.presentation.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {
    private lateinit var dateTime: LocalDateTime


    var hour = mutableStateOf("")
        private set
    var minute = mutableStateOf("")
        private set
    var second = mutableStateOf("")
        private set

    var amOrPm = mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            while (true) {
                dateTime = LocalDateTime.now()
                setClockTime()
                delay(1000L)
            }
        }
    }

    private fun setClockTime() {
        dateTime.let {
            hour.value = it.hour.toString()
            minute.value = if (it.minute < 10) "0" + it.minute else it.minute.toString()
            second.value =
                if (it.second == 0) "00" else if (it.second < 10) "0" + it.second else it.second.toString()
            amOrPm.value = if (it.hour > 12) "PM" else "AM"
        }
    }
}