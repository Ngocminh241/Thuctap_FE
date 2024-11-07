package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.thuctap_fe.R

@Composable
fun ProfileScreen(navController: NavController? = null) {
    var name by remember { mutableStateOf("GiapDQ") }
    var email by remember { mutableStateOf("quanggiap04@gmail.com") }
    Scaffold(
        topBar = {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 15.dp, end = 15.dp)
                    .padding(WindowInsets.statusBars.asPaddingValues())
            ) {
                IconButton(onClick = {
                    navController?.popBackStack()
                }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Thông tin cá nhân",
                        fontSize = 26.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        color = Color.Black
                    )
                }
            }
        },
        content = { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                //ảnh avatar
                Image(
                    painter = painterResource(id = R.drawable.anhlon),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )

                Spacer(modifier = Modifier.height(50.dp))

                //tên
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = {
                        Text(
                            text = "Tên người dùng",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    },
                    modifier = Modifier
                        .border(
                            width = 5.dp,
                            shape = RoundedCornerShape(35.dp),
                            brush = Brush.horizontalGradient(
                                listOf(Color("#FDC890".toColorInt()), Color("#FF9382".toColorInt()))
                            )
                        ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))


                // email
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    readOnly = true,
                    placeholder = {
                        Text(
                            text = "Email",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    },
                    modifier = Modifier
                            .border(
                                width = 5.dp,
                                shape = RoundedCornerShape(35.dp),
                                brush = Brush.horizontalGradient(
                                    listOf(Color("#FDC890".toColorInt()), Color("#FF9382".toColorInt()))
                                )
                            ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                )

                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent // Set container color to transparent
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color("#FDC890".toColorInt()), Color("#FF9382".toColorInt()))
                            ),
                            shape = RoundedCornerShape(30.dp) // Add shape if needed
                        )
                ) {
                    Text(
                        text = "Lưu",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                }


            }

        })
}

@Composable
@Preview(showBackground = true)
fun preview(modifier: Modifier = Modifier) {
    ProfileScreen()
}