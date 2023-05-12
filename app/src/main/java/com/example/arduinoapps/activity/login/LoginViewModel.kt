package com.example.arduinoapps.activity.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    private val _email = MutableLiveData<String>("")
    private val _password = MutableLiveData<String>("")
    private val _loading = MutableLiveData<Boolean>(false)


    fun setEmail(value: String) {
        _email.value = value
    }

    fun setPassword(value: String) {
        _password.value = value
    }

    fun setLoading(value: Boolean) {
        _loading.value = value
    }


    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val loading: LiveData<Boolean> = _loading
}