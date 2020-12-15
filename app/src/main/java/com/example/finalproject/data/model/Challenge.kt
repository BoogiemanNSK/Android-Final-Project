package com.example.finalproject.data.model

import com.google.gson.annotations.SerializedName

data class Challenge(
    @SerializedName("Id")
    val id: Int?,
    @SerializedName("Title")
    val name: String,
    @SerializedName("Description")
    val description: String,
    @SerializedName("Requirements")
    val requirements: String,
    @SerializedName("AuthorId")
    val authorId: Int?,
    @SerializedName("Author")
    val author: User,
    @SerializedName("Raiting")
    val raiting: Int,
    @SerializedName("Taken")
    val taken: Int,
    @SerializedName("Tags")
    val tags: Array<Tag>
)
