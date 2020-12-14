package com.example.finalproject.data.model

import com.google.gson.annotations.SerializedName

data class Challenge(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("requirements")
    val requirements: String,
    @SerializedName("author")
    val author: User,
    @SerializedName("raiting")
    val raiting: Int,
    @SerializedName("taken")
    val taken: Int,
    @SerializedName("tags")
    val tags: Array<Tag>
)
