package com.example.composesample.authmoduleyt.domain.use_case

import com.example.composesample.authmoduleyt.domain.model.RegisterInputValidationType
import com.google.common.truth.Truth
import org.junit.Test
//testing input validation cases
class ValidateRegisterInputCaseTest {

    private val validateRegisterInputUseCase = ValidateRegisterInputCase()

    @Test
    fun `test register input with correct email and password returns valid`() {
        val result = validateRegisterInputUseCase(
            "TestEmail@gmail.com",
            password = "ValidPassword1!",
            passwordRepeated = "ValidPassword1!"
        )
        Truth.assertThat(result).isEqualTo(RegisterInputValidationType.Valid)
    }

    @Test
    fun `test register input with no email gives correct return type`() {
        val result = validateRegisterInputUseCase(
            "TestEmailgmail.com", password = "ValidPassword1!", passwordRepeated = "ValidPassword1!"
        )
        Truth.assertThat(result).isEqualTo(RegisterInputValidationType.NoEmail)
    }

    @Test
    fun `test register input with not matching passwords gives correct return type`() {
        val result = validateRegisterInputUseCase(
            "TestEmail@gmail.com",
            password = "ValidPassworsd1!",
            passwordRepeated = "ValidPassword1!"
        )
        Truth.assertThat(result).isEqualTo(RegisterInputValidationType.PasswordDoNotMatch)
    }

    @Test
    fun `test register input with upper case missing password gives correct return type`() {
        val result = validateRegisterInputUseCase(
            "TestEmail@gmail.com",
            password = "invalidpassword1!",
            passwordRepeated = "invalidpassword1!"
        )
        Truth.assertThat(result).isEqualTo(RegisterInputValidationType.PasswordUpperCaseMissing)
    }

    @Test
    fun `test register input with number missing password gives correct return type`() {
        val result = validateRegisterInputUseCase(
            "TestEmail@gmail.com", password = "ValidPassword!", passwordRepeated = "ValidPassword!"
        )
        Truth.assertThat(result).isEqualTo(RegisterInputValidationType.PasswordNumberMissing)
    }

    @Test
    fun `test register input with special char missing password gives correct return type`() {
        val result = validateRegisterInputUseCase(
            "TestEmail@gmail.com", password = "ValidPassword1", passwordRepeated = "ValidPassword1"
        )
        Truth.assertThat(result).isEqualTo(RegisterInputValidationType.PasswordSpecialCharMissing)
    }

    @Test
    fun `test register input with password too short gives correct return type`() {
        val result = validateRegisterInputUseCase(
            "TestEmail@gmail.com", password = "Valid1!", passwordRepeated = "Valid1!"
        )
        Truth.assertThat(result).isEqualTo(RegisterInputValidationType.PasswordTooShort)
    }
}
