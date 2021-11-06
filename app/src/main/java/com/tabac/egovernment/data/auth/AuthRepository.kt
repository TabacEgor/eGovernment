package com.tabac.egovernment.data.auth

import com.tabac.egovernment.data.local.ISession
import com.tabac.egovernment.data.retrofitService

class AuthRepository(
    private val session: ISession,
    private val authService: AuthService
) {
    // TODO injection few services to repo
    val service: AuthService by retrofitService(AuthService::class.java, session)
}