package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.os.Bundle
import com.example.finalproject.menu_fragments.CreatedChallengesFragment
import com.example.finalproject.menu_fragments.ProfileFragment
import com.example.finalproject.menu_fragments.SearchFragment
import com.example.finalproject.menu_fragments.TakenChallengesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var searchFragment: SearchFragment
    private lateinit var takenChallengesFragment: TakenChallengesFragment
    private lateinit var createdChallengesFragment: CreatedChallengesFragment
    private lateinit var userProfileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_button.setOnClickListener{ onSearchClick() }
        challenge_button.setOnClickListener { onChallengesClick() }
        profile_button.setOnClickListener { onProfileClick() }

        searchFragment = SearchFragment.newInstance()
        takenChallengesFragment = TakenChallengesFragment.newInstance()
        createdChallengesFragment = CreatedChallengesFragment.newInstance()
        userProfileFragment = ProfileFragment.newInstance()

        navigateTo(searchFragment)
    }

    private fun onSearchClick() {
        navigateTo(searchFragment)
    }

    private fun onProfileClick() {
        navigateTo(userProfileFragment)
    }

    fun onChallengesClick() {
        navigateTo(createdChallengesFragment)
    }

    fun onTakenClick() {
        navigateTo(takenChallengesFragment)
    }

    fun createNewChallenge() {
        val intent = Intent(this, CreateChallenge::class.java)
        startActivity(intent)
    }

    fun viewChallengeInfo(challengeId: Int) {
        val intent = Intent(this, ViewChallenge::class.java)
        intent.putExtra(getString(R.string.extra_challenge_id), challengeId)
        startActivity(intent)
    }

    private fun navigateTo(fragment: Fragment, withBackStack: Boolean = false) {
        with (supportFragmentManager.beginTransaction()) {
            replace(R.id.fragment_container, fragment)
            if (withBackStack) addToBackStack(null)
            commit()
        }
    }

}