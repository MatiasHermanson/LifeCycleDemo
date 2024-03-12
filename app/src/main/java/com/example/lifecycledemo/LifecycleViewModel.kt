package com.example.lifecycledemo


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LifecycleViewModel: ViewModel() {

    private val _lifecycleEvents = MutableLiveData<String>()
    val lifecycleEvents: LiveData<String> = _lifecycleEvents
    val DemoObserver = lifecycleEvents

    fun addLifecycleEvent(event: String): LiveData<String> {
        _lifecycleEvents.value = DemoObserver().toString()
        _lifecycleEvents.value = "${System.currentTimeMillis()} - $event\n*****\n${_lifecycleEvents.value}"
        return lifecycleEvents
        return DemoObserver
    }

    companion object {
        fun addLifecycleEvent(s: Companion): Any {
            return "HELP ME PLEASE!"
        }
    }
}
