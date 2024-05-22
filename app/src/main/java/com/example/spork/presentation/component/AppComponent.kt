package com.example.spork.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spork.R
import com.example.spork.ui.theme.mainOrange
import com.example.spork.ui.theme.primary
import com.example.spork.ui.theme.secondButton

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(backButton: () -> Unit){
    TopAppBar(title = {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(onClick = backButton) {
                Image(painter = painterResource(id = R.drawable.arrowleft),
                    contentDescription = "back arrow",
                    modifier = Modifier.padding(end = 12.dp)
                )
            }

        }
    })
}

// Bold Orange Text Component
@Composable
fun BoldTextOrangeComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.orange_7900),
        textAlign = TextAlign.Center
    )
}

// Bold Text Component
@Composable
fun BoldTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.blackfont),
        textAlign = TextAlign.Center
    )
}

// Normal Text Component
@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.blackfont),
        textAlign = TextAlign.Center
    )
}

// Outlined Text Field Normal
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyOutlinedTextField(labelValue: String, value: String, painterResource: Painter){

    var textValue by remember {
        mutableStateOf("")
    }

    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.orange_7900),
        textAlign = TextAlign.Start
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = mainOrange,
            focusedLabelColor = mainOrange,
            cursorColor = primary,
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue,
        onValueChange = {
            textValue = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "email logo")
        },
    )
}

// Outlined Text Field Password
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PasswordTextField(labelValue: String, value: String, painterResource: Painter){

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.orange_7900),
        textAlign = TextAlign.Start
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = mainOrange,
            focusedLabelColor = mainOrange,
            cursorColor = primary,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password,
        onValueChange = {
            password = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "lock logo")
        },
        trailingIcon = {
            val iconImage = if (passwordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            var description = if (passwordVisible){
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )

}

@Composable
fun ButtonComponent(value: String, onTaskClick: () -> Unit){
    Button(
        onClick = onTaskClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(52.dp),
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(mainOrange)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    color = mainOrange
                ),
            contentAlignment = Alignment.Center
        ){
            Text(text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

// Google Button Component
@Composable
fun GoogleButtonComponent(value: String, image: Painter, onTaskClick: () -> Unit){
    Button(
        onClick = onTaskClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(52.dp),
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(secondButton)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    color = secondButton
                ),
            contentAlignment = Alignment.Center,
        ){
            Image(modifier = Modifier.padding(end = 280.dp),painter = image, contentDescription = "")
            Text(text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = mainOrange
            )
        }
    }

}