package com.example.clickretina.network

import ApiResponse
import retrofit2.http.GET
import javax.inject.Singleton

interface ApiService {
    @GET("android-assesment/profile/refs/heads/main/data.json")
    suspend fun  getProfile():ApiResponse
}