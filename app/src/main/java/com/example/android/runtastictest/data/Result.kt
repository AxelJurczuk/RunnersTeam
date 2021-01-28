package com.example.android.runtastictest.data

import com.example.android.runtastictest.model.Group

sealed class Result {

    data class Success (var list: List<Group>):Result()
    data class Failure (val error: String):Result()
}