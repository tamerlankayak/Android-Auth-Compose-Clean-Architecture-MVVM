package com.example.composesample.authmoduleyt.domain.use_case

import com.example.composesample.authmoduleyt.domain.model.LoginInputValidationType

class ValidateLoginInputCase {

    operator fun invoke(email: String, password: String): LoginInputValidationType {
        if (email.isEmpty() || password.isEmpty()) {
            return LoginInputValidationType.EmptyField
        }
        if ("@" !in email) {
            return LoginInputValidationType.NoMail
        }
        return LoginInputValidationType.Valid
    }
}