package com.example.composesample.authmoduleyt.di

import com.example.composesample.authmoduleyt.data.AuthRepositoryImpl
import com.example.composesample.authmoduleyt.domain.repository.AuthRepository
import com.example.composesample.authmoduleyt.domain.use_case.ValidateLoginInputCase
import com.example.composesample.authmoduleyt.domain.use_case.ValidateRegisterInputCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideValidateLoginInputUseCase(): ValidateLoginInputCase {
        return ValidateLoginInputCase()
    }

    @Provides
    @Singleton
    fun provideValidateRegisterInputUseCase(): ValidateRegisterInputCase {
        return ValidateRegisterInputCase()
    }

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }
}