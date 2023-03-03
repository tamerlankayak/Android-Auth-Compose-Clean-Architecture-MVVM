package com.example.composesample.authmoduleyt.presentation.components.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composesample.authmoduleyt.domain.model.LoginInputValidationType
import com.example.composesample.authmoduleyt.domain.use_case.ValidateLoginInputCase
import com.example.composesample.authmoduleyt.presentation.components.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateLoginInputCase: ValidateLoginInputCase
):ViewModel() {
    var loginState by mutableStateOf(LoginState())
        private set

    fun onEmailInputChange(newValue: String) {
        loginState = loginState.copy(emailInput = newValue)
        checkInputValidation()
    }

    fun onPasswordInputChange(newValue: String) {
        loginState = loginState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    fun onToggleVisualTransformation() {
        loginState = loginState.copy(isPasswordShown = !loginState.isPasswordShown)
    }

    fun onLoginClick() {

    }

    private fun checkInputValidation() {
        val validationResult = validateLoginInputCase(
            loginState.emailInput,
            loginState.passwordInput
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(type: LoginInputValidationType) {
        loginState = when (type) {
            LoginInputValidationType.EmptyField -> {
                loginState.copy(errorMessageInput = "Empty fields left", isInputValid = false)
            }
            LoginInputValidationType.NoMail -> {
                loginState.copy(errorMessageInput = "No valid email", isInputValid = false)
            }
            LoginInputValidationType.Valid -> {
                loginState.copy(errorMessageInput = null, isInputValid = true)
            }
        }
    }
}