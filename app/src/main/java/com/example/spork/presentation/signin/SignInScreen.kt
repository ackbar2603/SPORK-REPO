package com.example.spork.presentation.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spork.R
import com.example.spork.presentation.component.BoldTextComponent
import com.example.spork.presentation.component.ButtonComponent
import com.example.spork.presentation.component.GoogleButtonComponent
import com.example.spork.presentation.component.MyOutlinedTextField
import com.example.spork.presentation.component.NormalTextComponent
import com.example.spork.presentation.component.PasswordTextField
import com.example.spork.navigation.Screen


@Composable
fun signInScreen(navController: NavController){

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ){
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Image(painter = painterResource(id = R.drawable.sprorkinglogoandtext),
                contentDescription = "Sporking",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))

            BoldTextComponent(value = stringResource(id = R.string.welcome))
            NormalTextComponent(value = stringResource(id = R.string.temukan_lapangan))

            Spacer(modifier = Modifier.height(50.dp))

            MyOutlinedTextField(labelValue = stringResource(id = R.string.email), value = stringResource(
                id = R.string.email), painterResource(id = R.drawable.mail)
            )

            Spacer(modifier = Modifier.height(16.dp))

            PasswordTextField(labelValue = stringResource(id = R.string.password), value = stringResource(
                id = R.string.password), painterResource = painterResource(id = R.drawable.lock)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Spacer(modifier = Modifier.height(30.dp))
            BoldTextComponent(value = stringResource(id = R.string.lupa_password))

            BoldTextComponent(value = stringResource(id = R.string.belum_punya_akun))

            Spacer(modifier = Modifier.height(30.dp))
            ButtonComponent(value = stringResource(id = R.string.masuk), onTaskClick = {null})

            Spacer(modifier = Modifier.height(15.dp))
            NormalTextComponent(value = stringResource(id = R.string.atau))
            Spacer(modifier = Modifier.height(15.dp))

            GoogleButtonComponent(value = stringResource(id = R.string.daftar_dengan_google),
                image = painterResource(id = R.drawable.google_icon), onTaskClick = {navController.navigate(Screen.SignUp.route)}
            )

        }
    }

}

//@Preview
//@Composable
//fun signInScreenPreview(){
//    signInScreen()
//}