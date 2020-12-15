package com.example.finalproject

//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.finalproject.data.AuthorizationService
//import com.example.finalproject.data.requests.LoginRequest
//import com.example.finalproject.data.responses.TokenResponse
//import com.example.finalproject.preferences.SharedPreferencesWrapper
//import kotlinx.android.synthetic.main.activity_login.*
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import javax.inject.Inject
//
//class LoginActivity : AppCompatActivity() {
//
//    @Inject
//    lateinit var authorizationService: AuthorizationService
//
//    @Inject
//    lateinit var sharedPreferences: SharedPreferencesWrapper
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
//        (application as FinalApplication).appComponent.inject(this)
//
//        login_button.setOnClickListener { onLogin() }
//        sign_up_button.setOnClickListener { onSignUp() }
//        google_oauth.setOnClickListener { onGoogleLogin() }
//        facebook_oauth.setOnClickListener { onFacebookLogin() }
//        twitter_oauth.setOnClickListener { onTwitterLogin() }
//    }
//
//    private fun onLogin() {
//        authorizationService.login(LoginRequest(login_edit_text.text.toString(),
//        password_edit_text.text.toString())).enqueue(object : Callback<TokenResponse> {
//            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
//                Toast.makeText(
//                    this@LoginActivity, R.string.login_error, Toast.LENGTH_SHORT
//                ).show()
//            }
//
//            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
//                sharedPreferences.set(getString(R.string.token_key),
//                    response.body()?.token.orEmpty())
//                val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        })
//    }
//
//    private fun onSignUp() {
//
//    }
//
//    private fun onGoogleLogin() {
//        // TODO To be implemented
//    }
//
//    private fun onFacebookLogin() {
//        // TODO To be implemented
//    }
//
//    private fun onTwitterLogin() {
//        // TODO To be implemented
//    }
//
//}