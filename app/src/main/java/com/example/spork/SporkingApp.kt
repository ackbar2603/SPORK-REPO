package com.example.spork

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.spork.presentation.news.newsDetailScreen
import com.example.spork.presentation.news.newsScreen
import com.example.spork.presentation.signin.signInScreen
import com.example.spork.presentation.signup.signUpScreen
import com.example.spork.presentation.testing.agreementScreen
import com.example.spork.presentation.welcome.welcomeScreen
import com.example.spork.navigation.Screen


@Composable
fun sporkingPostOfficeApp(
    navController: NavHostController = rememberNavController()
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.NewsScreen.route
        ){
            composable(Screen.Welcome.route){
                welcomeScreen(navController)
            }
            composable(Screen.SignIn.route){
                signInScreen(navController)
            }
            composable(Screen.SignUp.route){
                signUpScreen(navController)
            }
            composable(Screen.NewsScreen.route){
                newsScreen(navController)
            }
            composable(
                Screen.NewsDetail.route + "/{berita}",
                arguments = listOf(navArgument("berita") {type = NavType.IntType})
                ){navBackStackEntry ->
                newsDetailScreen(
                    navController = navController,
                    berita = navBackStackEntry.arguments?.getInt("berita")
                )
            }



            //This composable screen is for testing purposes only
            composable(Screen.Agreement.route){
                agreementScreen()
            }
        }
    }
}


@Composable
@Preview
fun sporkingPostOfficeAppPreview(){
    sporkingPostOfficeApp()
}