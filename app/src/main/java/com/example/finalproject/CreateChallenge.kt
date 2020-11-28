package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_challenge.*

class CreateChallenge : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_challenge)
        create_cancel_button.setOnClickListener { onCancelCreation() }
    }

    private fun onCancelCreation() {
        finish()
    }
    
}