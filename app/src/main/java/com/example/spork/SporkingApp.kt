package com.example.spork

import android.widget.MediaController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spork.presentation.signin.signInScreen
import com.example.spork.presentation.signup.signUpScreen
import com.example.spork.presentation.testing.agreementScreen
import com.example.spork.presentation.welcome.welcomeScreen
import com.example.spork.screen.Screen


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
            startDestination = Screen.Welcome.route
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


            //This composable screen is for testing purposes only
            composable(Screen.Agreement.route){
                agreementScreen(navController)
            }
        }
    }
}


@Composable
@Preview
fun sporkingPostOfficeAppPreview(){
    sporkingPostOfficeApp()
}