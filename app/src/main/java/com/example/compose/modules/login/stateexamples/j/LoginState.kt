/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.compose.modules.login.stateexamples.j

//@Stable

data class LoginState(
    val email: String? = null,
    val password: String? = null,
    val submitButtonEnabled: Boolean = false
) /** * one-time event */


// user actions
sealed class LoginEvent {
    data class EmailChange(val newValue: String) : LoginEvent()
    data class PasswordChange( val newValue: String) : LoginEvent()
    data class LoginClicked(val email: String, val password: String) : LoginEvent()
    object ShowPassword : LoginEvent()
}


