package com.example.composesample.authmoduleyt.domain.use_case

import com.example.composesample.authmoduleyt.domain.model.RegisterInputValidationType
import com.example.composesample.util.containsNumber
import com.example.composesample.util.containsSpecialChar
import com.example.composesample.util.containsUpperCase

class ValidateRegisterInputCase {

    operator fun invoke(
        email: String,
        password: String,
        passwordRepeated: String
    ): RegisterInputValidationType {
        if (email.isEmpty() || password.isEmpty() || passwordRepeated.isEmpty()) {
            return RegisterInputValidationType.EmptyField
        }
        if ("@" !in email) {
            return RegisterInputValidationType.NoEmail
        }
        if (password != passwordRepeated) {
            return RegisterInputValidationType.PasswordDoNotMatch
        }
        if (password.count() < 8) {
            return RegisterInputValidationType.PasswordTooShort
        }
        if (!password.containsNumber()) {
            return RegisterInputValidationType.PasswordNumberMissing
        }
        if (!password.containsUpperCase()){
            return RegisterInputValidationType.PasswordUpperCaseMissing
        }
        if (!password.containsSpecialChar()){
         return RegisterInputValidationType.PasswordSpecialCharMissing
        }
        return RegisterInputValidationType.Valid
    }

}