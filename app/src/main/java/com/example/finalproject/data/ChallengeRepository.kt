package com.example.finalproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalproject.data.model.Challenge
import com.example.finalproject.data.model.MyChallenge
import com.example.finalproject.data.requests.NewChallengeRequest
import io.reactivex.schedulers.Schedulers

class ChallengeRepository(
    var challengeApi: ChallengeApi
) {

    fun getAllChallenges(token: String): LiveData<List<Challenge>> {
        return challengeApi.getChallenges(token)
            .subscribeOn(Schedulers.io())
            .map {
                val challenges = it.challengesArray.map { a -> a }
                MutableLiveData(challenges)
            }.blockingGet()
    }

    fun getMyCreatedChallenges(): LiveData<List<Challenge>> {
        return challengeApi.getCreatedChallenges()
            .subscribeOn(Schedulers.io())
            .map {
                val challenges = it.challengesArray.map { a -> a }
                MutableLiveData(challenges)
            }.blockingGet()
    }

    fun getMyTakenChallenges(): LiveData<List<MyChallenge>> {
        return challengeApi.getMyChallenges()
            .subscribeOn(Schedulers.io())
            .map {
                val challenges = it.challengesArray.map { a -> a }
                MutableLiveData(challenges)
            }.blockingGet()
    }

    fun createNewChallenge(
        name: String,
        description: String,
        requirements: String,
        tags: Array<String>
    ) {
        challengeApi.createNewChallenge(
            NewChallengeRequest(
                name,
                description,
                requirements,
                tags
            )
        ).execute()
    }

    fun takeChallenge(challengeId: Int) {
        challengeApi.takeChallenge(challengeId).execute()
    }

    fun completeChallenge(myChallengeId: Int) {
        challengeApi.completeChallenge(myChallengeId).execute()
    }

    fun rejectChallenge(myChallengeId: Int) {
        challengeApi.rejectChallenge(myChallengeId).execute()
    }
}