package com.example.finalproject.data.requests

data class NewChallengeRequest(
    val name: String,
    val description: String,
    val requirements: String,
    val tags: Array<String>
)
