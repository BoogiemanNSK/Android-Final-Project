package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_challenge.*

class ViewChallenge : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_challenge)
        view_close_button.setOnClickListener { onCloseView() }
    }

    private fun onCloseView() {
        finish()
    }
    
}