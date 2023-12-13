package com.example.capstoneceriakids.UI.SplashScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class SplashScreenViewModel(private val repository : UserRepository) : ViewModel() {

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
}