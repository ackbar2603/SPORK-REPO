package com.example.spork.screen


sealed class Screen (val route: String){
    data object Welcome: Screen("welcome")
    data object SignIn: Screen("sign_in")
    data object SignUp: Screen("sign_up")
}