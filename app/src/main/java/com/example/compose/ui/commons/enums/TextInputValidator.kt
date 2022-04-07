package com.example.compose.ui.commons.enums

import android.util.Patterns.EMAIL_ADDRESS
import com.example.compose.R

sealed class TextInputValidator(
    var isValid: ((String) -> StringWrapper?) = { StringWrapper(R.string.something_wrong) }
) {
    class PhoneNumberValidator: TextInputValidator() {
        init {
            isValid = lambda@{
                return@lambda when {
                    it.isEmpty() -> cantBeEmpty()
                    !RegexPatterns.DIGITS_ONLY.matches(it) ->
                        StringWrapper { getString(R.string.should_be_digits_only, getString(R.string.phone_number)) }
                    !RegexPatterns.ELEVEN_OR_MORE.matches(it) -> tooShort(11)
                    else -> null
                }
            }
        }
    }

    class NewPasswordValidator: TextInputValidator() {
        init {
            isValid = validator@{
                return@validator when {
                    it.isEmpty() -> cantBeEmpty()
                    !RegexPatterns.EIGHT_OR_MORE.matches(it) -> tooShort(8)
                    !RegexPatterns.ONE_NUMBER_AND_CHARS.matches(it) ->
                        StringWrapper { getString(R.string.password_include_number_upper_case, getString(R.string.password)) }
                    else -> null
                }
            }
        }
    }
    class ActivationCodeValidator: TextInputValidator() {
        init {
            isValid = validator@{
                return@validator when {
                    it.isEmpty() -> cantBeEmpty()
                    !RegexPatterns.EIGHT_OR_MORE.matches(it) -> tooShort(8)
                    else -> null
                }
            }
        }
    }
    class FreeTextValidator : TextInputValidator() {
        init {
            isValid = { null }
        }
    }
    class TempPassValidator: TextInputValidator() {
        init {
            isValid = validator@{
                return@validator when {
                    it.isEmpty() -> cantBeEmpty()
                    else -> null
                }
            }
        }
    }
    class NotEmptyTextValidator : TextInputValidator() {
        init {
            isValid = validator@{
                return@validator when {
                    it.isEmpty() -> cantBeEmpty()
                    else -> null
                }
            }
        }
    }

    class TimeValidator : TextInputValidator() {
        init {
            isValid = validator@{
                return@validator when {
                    it.isEmpty() -> {
                        cantBeEmpty()
                    }
                    else -> null
                }
            }
        }
    }

    class OldPasswordValidator: TextInputValidator() {
        init {
            isValid = lambda@{
                return@lambda when {
                    it.isEmpty() -> cantBeEmpty()
                    !RegexPatterns.EIGHT_OR_MORE.matches(it) -> tooShort(8)
                    else -> null
                }
            }
        }
    }

    class OptionalEmailValidator : TextInputValidator() {
        init {
            isValid = validator@{
                return@validator when {

                    !EMAIL_ADDRESS.matcher(it.trim()).matches() && it.isNotEmpty() ->
                        StringWrapper { getString(R.string.invalid_email) }
                    else -> null
                }
            }
        }
    }

    class EmailValidator : TextInputValidator() {
        init {
            isValid = validator@{
                return@validator when {
                    it.isEmpty() -> {
                        cantBeEmpty()
                    }
                    !EMAIL_ADDRESS.matcher(it.trim()).matches() ->
                        StringWrapper { getString(R.string.invalid_email) }
                    else -> null
                }
            }
        }
    }
    fun cantBeEmpty(): StringWrapper {
        return StringWrapper {
            when (this@TextInputValidator) {
                is PhoneNumberValidator -> {
                    getString(R.string.cant_be_empty, getString(R.string.phone_number))
                }
                is NewPasswordValidator -> {
                    getString(R.string.cant_be_empty, getString(R.string.password))
                }
                is ActivationCodeValidator -> {
                    getString(R.string.cant_be_empty, getString(R.string.activation_code))
                }
                is TimeValidator ->{
                    getString(R.string.cant_be_empty, getString(R.string.time))
                }
                is NotEmptyTextValidator ->{
                    getString(R.string.cant_be_empty, getString(R.string.field))
                }
                is TempPassValidator -> {
                    getString(R.string.cant_be_empty, getString(R.string.temp_pass))
                }
                is EmailValidator -> {
                    getString(R.string.cant_be_empty, getString(R.string.email))
                }
                else -> getString(R.string.cant_be_empty, getString(R.string.phone_number))
            }
        }
    }
    fun tooShort(minimum: Int): StringWrapper {
        return StringWrapper {
            when (this@TextInputValidator) {
                is PhoneNumberValidator -> {
                    getString(R.string.too_short_less_than_phone, getString(R.string.phone_number), minimum)
                }
                is NewPasswordValidator -> {
                    getString(R.string.too_short_less_than_character, getString(R.string.password), minimum)
                }
                is OldPasswordValidator -> {
                    getString(R.string.too_short_less_than_character, getString(R.string.password), minimum)
                }
                is ActivationCodeValidator -> {
                    getString(R.string.too_short_less_than, getString(R.string.activation_code), minimum)
                }
                else -> getString(R.string.too_short_less_than_phone, getString(R.string.phone_number), minimum)
            }
        }
    }
}
