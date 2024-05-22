package com.chinhdev.assignment_kot104.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.chinhdev.assignment_kot104.R

class RegisterScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenRegister()
        }
    }
}

@Composable
fun ScreenRegister() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var repassword by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Divider(
                color = Color.Black, modifier = Modifier
                    .height(1.dp)
                    .width(140.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .height(85.dp)
                    .width(80.dp)
                    .padding(10.dp)
            )
            Divider(
                color = Color.Black, modifier = Modifier
                    .height(1.dp)
                    .width(140.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "WELCOME",
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 20.dp),
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily(
                Font(R.font.merriweather_regular)
            ),
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, end = 15.dp)
                .shadow(8.dp)
                .background(Color.White)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    "Name:",
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Left
                )
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#E0E0E0".toColorInt()),
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,
                    ),

                    )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Email:",
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Left
                )
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#E0E0E0".toColorInt()),
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "Password:",
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Left
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    visualTransformation = if (pass) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#E0E0E0".toColorInt()),
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                    trailingIcon = {
                        val icon = if (pass) {
                            painterResource(id = R.drawable.eyenot)
                        } else {
                            painterResource(id = R.drawable.eye)
                        }
                        Icon(
                            painter = icon,
                            contentDescription = "Toggle password visibility",
                            modifier = Modifier
                                .clickable {
                                    pass = !pass
                                }
                                .height(25.dp)
                                .width(25.dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "Confirm Password:",
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Left
                )

                TextField(
                    value = repassword,
                    onValueChange = { repassword = it },
                    visualTransformation = if (pass) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#E0E0E0".toColorInt()),
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                    trailingIcon = {
                        val icon = if (pass) {
                            painterResource(id = R.drawable.eyenot)
                        } else {
                            painterResource(id = R.drawable.eye)
                        }
                        Icon(
                            painter = icon,
                            contentDescription = "Toggle password visibility",
                            modifier = Modifier
                                .clickable {
                                    pass = !pass
                                }
                                .height(25.dp)
                                .width(25.dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .width(300.dp)
                        .height(50.dp)
                        .background(color = Color.Black)
                        .clickable { },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,


                    ) {
                    Text("SIGN UP", fontSize = 18.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Already have account? SIGN IN", fontSize = 18.sp)
            }
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenRegisterPreview() {
    ScreenRegister()
}