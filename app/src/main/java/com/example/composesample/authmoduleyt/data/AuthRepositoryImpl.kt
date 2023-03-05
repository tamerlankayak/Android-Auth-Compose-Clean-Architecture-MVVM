package com.example.composesample.authmoduleyt.data

import com.example.composesample.authmoduleyt.domain.repository.AuthRepository
import kotlinx.coroutines.delay

//executig threads with coroutines
class AuthRepositoryImpl : AuthRepository {

    //1 second simulaion of loading
    override suspend fun login(email: String, password: String): Boolean {
        delay(1000)
        return true
    }

    override suspend fun register(email: String, password: String): Boolean {
        delay(1000)
        return true
    }
}
