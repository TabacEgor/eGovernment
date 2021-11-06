package com.tabac.egovernment.data.auth

import com.tabac.egovernment.model.response.AuthResponse
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("/")
    suspend fun login(@Header("Authorization") authHeader: String): Response<AuthResponse>
}