package com.example.composesample.authmoduleyt.domain.model

enum class RegisterInputValidationType {
    EmptyField,
    NoEmail,
    PasswordDoNotMatch,
    PasswordUpperCaseMissing,
    PasswordNumberMissing,
    PasswordSpecialCharMissing,
    PasswordTooShort,
    Valid
}