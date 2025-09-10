package com.example.clickretina.repository

import User
import com.example.clickretina.network.ApiService
import javax.inject.Inject
class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getProfile(): User {
        return apiService.getProfile().user
    }
}
