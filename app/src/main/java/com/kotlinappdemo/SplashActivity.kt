package com.kotlinappdemo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : ViewModel() {
    var tapcount: Int = 0
    lateinit var context: Context

    init {
        viewModelScope.launch {
            tapcount++

            delay(1000)
            Toast.makeText(context, "View Model run successfully", Toast.LENGTH_LONG).show()
        }
    }


}
