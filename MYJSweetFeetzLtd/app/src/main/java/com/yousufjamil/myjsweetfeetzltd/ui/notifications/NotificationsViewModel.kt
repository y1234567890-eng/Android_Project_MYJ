package com.yousufjamil.myjsweetfeetzltd.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to Notifications! You have no pending notifications."
    }
    val text: LiveData<String> = _text
}