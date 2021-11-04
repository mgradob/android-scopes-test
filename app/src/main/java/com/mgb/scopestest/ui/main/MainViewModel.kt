package com.mgb.scopestest.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    init {
        viewModelScope.launch {
            while (true) {
                Log.d("ViewModelScope", "launch | Working...")
                delay(1000)
            }
        }
    }
}