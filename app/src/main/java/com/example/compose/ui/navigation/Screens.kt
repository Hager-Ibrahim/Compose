package com.example.compose.ui.navigation

//sealed class Screens(val route: String) {
//    object LoginScreen: Screens("login")
//    object StaffScreen: Screens("staff")
//}


//sealed class Screens(val route: String) {
//    object LoginScreen: Screens("login")
//    object StaffScreen: Screens("staff/{email}"){
//        fun passEmail(email: String): String{
//            return "staff/$email"
//        }
//    }
//}

//const val EMAIL_KEY ="email"

//sealed class Screens(val route: String) {
//    object LoginScreen: Screens("login")
//    object StaffScreen: Screens("staff/{$EMAIL_KEY}"){
//        fun passEmail(email: String): String{
//            return this.route.replace("{$EMAIL_KEY}",email)
//        }
//    }
//}

const val EMAIL_KEY ="email"
const val PASSWORD_KEY="password"

sealed class Screens(val route: String) {
    object LoginScreen : Screens("login")
    object StaffScreen : Screens("staff/{$EMAIL_KEY}/{$PASSWORD_KEY}") {
        fun passData(email: String, password: String): String {
            return "staff/$email/$password"
        }
    }
}