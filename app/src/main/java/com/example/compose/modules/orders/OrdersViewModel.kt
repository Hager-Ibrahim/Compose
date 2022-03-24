package com.example.compose.modules.orders

import android.util.Log
import androidx.lifecycle.ViewModel

class OrdersViewModel : ViewModel(){

    init {
        fakeNetworkCall()
    }

    fun onStart() {
        Log.d("TEST", "onStart: ")

        // start task - the composable has entered the composition
    }

    fun onStop() {
        Log.d("TEST", "onStop: ")

        // cancel task - the composable has left the composition
    }

    private fun fakeNetworkCall(){
        Log.d("TEST", "fakeNetworkCall: ")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TEST", "onCleared: ")
    }


}