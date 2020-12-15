package com.example.finalproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.AuthorizationService
import com.example.finalproject.data.requests.LoginRequest
import com.example.finalproject.data.responses.TokenResponse
import com.example.finalproject.preferences.SharedPreferencesWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authorizationService: AuthorizationService,
    private val sharedPreferences: SharedPreferencesWrapper
) : ViewModel() {

    private val _loggedIn: MutableLiveData<Boolean> = MutableLiveData()
    val loggedIn: LiveData<Boolean> get() = _loggedIn

    fun login(email: String, pass: String, key: String) {
        authorizationService.login(LoginRequest(email, pass))
            .enqueue(object : Callback<TokenResponse> {

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    _loggedIn.postValue(false)
                }

                override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                    sharedPreferences.set(key, response.body()?.token.orEmpty())
                    _loggedIn.postValue(true)
                }

            })
    }

}