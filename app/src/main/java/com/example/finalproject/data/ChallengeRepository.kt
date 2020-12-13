package com.example.finalproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalproject.data.model.Challenge
import io.reactivex.schedulers.Schedulers

class ChallengeRepository(
    var challengeApi: ChallengeApi
) {

    /*fun getAllChallenges(): LiveData<List<Challenge>> {
        return challengeApi.getChallenges()
            .map {
                val challenges = it.challengesArray
                MutableLiveData(challenges)
            }.subscribeOn(Schedulers.io())
            .blockingGet()
    }*/

}