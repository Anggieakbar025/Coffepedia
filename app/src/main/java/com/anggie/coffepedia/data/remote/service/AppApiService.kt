package com.anggie.coffepedia.data.remote.service

import com.anggie.coffepedia.data.remote.response.CoffeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AppApiService {
    @GET("api")
    suspend fun getCoffeList(): Response<List<CoffeResponse?>?>?

    @GET("api/{id}")
    suspend fun getCoffeDetail(@Path("id") id: Int): Response<List<CoffeResponse?>?>?
}