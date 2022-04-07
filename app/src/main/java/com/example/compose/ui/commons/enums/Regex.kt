package com.example.compose.ui.commons.enums


enum class RegexPatterns(private val pattern: Regex) {
    DIGITS_ONLY(Regex("^\\d+$")),
    EIGHT_OR_MORE(Regex(".{8,}")),
    ELEVEN_OR_MORE(Regex(".{11,}")),
    TEN_OR_MORE(Regex(".{10,}")),
    ONE_NUMBER_AND_CHARS(Regex("(?=.*\\d)(?=.*[a-z|A-Z]).*"))
    ;

    fun matches(string: String): Boolean{
        return pattern.matches(string)
    }
}