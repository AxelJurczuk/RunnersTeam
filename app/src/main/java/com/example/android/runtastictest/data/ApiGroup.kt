package com.example.android.runtastictest.data

import com.example.android.runtastictest.model.Group
import com.example.android.runtastictest.model.GroupResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiGroup {

    @GET("groups.json")
    fun getGroups(): Call<GroupResponse>
}