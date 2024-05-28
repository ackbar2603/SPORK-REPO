package com.example.spork.navigation


sealed class Screen (val route: String){
    data object Welcome: Screen("welcome")
    data object SignIn: Screen("sign_in")
    data object SignUp: Screen("sign_up")
    data object Agreement: Screen("agreement")
    data object NewsDetail: Screen("news_detail")
    data object NewsScreen: Screen("news_screen")
}