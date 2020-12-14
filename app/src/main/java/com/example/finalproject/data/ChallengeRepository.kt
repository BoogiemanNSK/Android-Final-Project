package com.example.finalproject.data

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

}