package com.example.composesample.aurhmoduleyt.domain.use_case

import com.example.composesample.authmoduleyt.domain.model.LoginInputValidationType
import com.example.composesample.authmoduleyt.domain.use_case.ValidateLoginInputCase
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ValidateLoginInputCaseTest {
    private val validateLoginInputUseCase = ValidateLoginInputCase();

    @Test
    fun `test empty field returns ValidationType empty field`() {
        val result = validateLoginInputUseCase(email = "", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.EmptyField)
    }

    @Test
    fun `test empty password field returns ValidationType empty field`() {
        val result = validateLoginInputUseCase(email = "tamerlan@gmail.com", password = "")
        assertThat(result).isEqualTo(LoginInputValidationType.EmptyField)
    }

    @Test
    fun `test no email returns ValidationType no mail`() {
        val result = validateLoginInputUseCase(email = "tamerlan.com", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.NoMail)
    }


    @Test
    fun `test everything is correct return validation type valid`() {
        val result = validateLoginInputUseCase(email = "tamerlankayak@gmail.com", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.Valid)
    }
}