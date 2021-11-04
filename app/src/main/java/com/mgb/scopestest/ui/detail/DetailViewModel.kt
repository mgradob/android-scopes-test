package com.mgb.scopestest.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    val liveData: LiveData<String>

    init {
        viewModelScope.launch {
            while (true) {
                Log.d("ViewModelScope", "detail |launch | Working...")
                delay(1000)
            }
        }

        liveData = liveData(timeoutInMs = 0) {
            while (true) {
                Log.d("LiveDataScope", "launch | Working...")
                emit("${System.currentTimeMillis()}")
                delay(1000)
            }
        }
    }
}