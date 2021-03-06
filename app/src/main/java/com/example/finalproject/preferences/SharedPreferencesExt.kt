package com.example.finalproject.preferences

import android.content.SharedPreferences

fun SharedPreferences.change(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}