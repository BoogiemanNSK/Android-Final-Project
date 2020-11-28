package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener { onLogin() }
        sign_up_button.setOnClickListener { onSignUp() }
        google_oauth.setOnClickListener { onGoogleLogin() }
        facebook_oauth.setOnClickListener { onFacebookLogin() }
        twitter_oauth.setOnClickListener { onTwitterLogin() }
    }

    private fun onLogin() {
        // TODO Perform any required checks with backend
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun onSignUp() {
        // TODO To be implemented
    }

    private fun onGoogleLogin() {
        // TODO To be implemented
    }

    private fun onFacebookLogin() {
        // TODO To be implemented
    }

    private fun onTwitterLogin() {
        // TODO To be implemented
    }

}