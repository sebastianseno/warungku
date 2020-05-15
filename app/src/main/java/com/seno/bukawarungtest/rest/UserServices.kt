package com.seno.bukawarungtest.rest

import retrofit2.http.GET

interface UserServices {

    @GET("api/users")
    suspend fun getUsers(): UserData
}