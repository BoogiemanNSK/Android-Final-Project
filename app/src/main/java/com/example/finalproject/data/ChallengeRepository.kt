package com.example.finalproject.data

import com.example.finalproject.data.requests.NewChallengeRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ChallengeRepository(
    var challengeApi: ChallengeApi
) {

    fun getAllChallenges() {
        challengeApi.getChallenges()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe ({
           // TODO Do something with result
        }, { error ->
            error.printStackTrace()
        })
    }

    fun getMyTakenChallenges() {
        challengeApi.getMyChallenges()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe ({
           // TODO Do something with result
        }, { error ->
            error.printStackTrace()
        })
    }

    fun getMyCreatedChallenges() {
        challengeApi.getChallenges()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe ({
           // TODO Do something with result
        }, { error ->
            error.printStackTrace()
        })
    }

    fun postNewChallenge(name: String, description: String, requirements: String, tags: Array<String>) {
        challengeApi.createNewChallenge(
            NewChallengeRequest(
                name,
                description,
                requirements,
                tags
            )
        ).execute()
    }

}