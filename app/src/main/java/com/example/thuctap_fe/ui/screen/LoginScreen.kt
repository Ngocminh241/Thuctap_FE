package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thuctap_fe.R
import com.example.thuctap_fe.navigation.Screen

//var nav: NavController? = null
//@Preview
//DANGNHAP

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    var isClicked by remember { mutableStateOf(false) } // Biến trạng thái để theo dõi khi nhấn vào "Đăng Ký"

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.manhinhdangnhap),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        IconButton(onClick = {
            navController?.popBackStack()
        },
            modifier = Modifier.offset(10.dp,25.dp)
        )
        {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "", tint = Color.White,
                modifier = Modifier.size(50.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {





            // Column chứa các trường nhập liệu và nút đăng nhập
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var username by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }
                Text(
                    text = "ĐĂNG NHẬP",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                // Email Input
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 10.dp),
                    placeholder = { Text(text = "Nhập Email của bạn") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                )

                // Password Input
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    placeholder = { Text(text = "Nhập Mật Khẩu") },
                    shape = RoundedCornerShape(25.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image =
                            if (passwordVisible)
                                painterResource(id = R.drawable.hide)
                            else
                                painterResource(id = R.drawable.view)
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = image,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                )

                // Login Button
                Button(
                    onClick = {
                        navController?.navigate(Screen.Main.route)

                    },
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
                        text = "Đăng Nhập",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                }
            }

            // SIGN UP Text
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center, // Canh giữa theo chiều ngang
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bạn đã có tài khoản ?  ",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_variable_fontwght))
                )
                Text(
                    text = "Đăng Ký",
//                    if (isClicked) Color.Yellow else // Thay đổi màu khi nhấn
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    modifier = Modifier
                        .wrapContentSize() // Giới hạn vùng nhấn chỉ bao quanh text
                        .clickable {
                            isClicked = !isClicked // Thay đổi trạng thái khi nhấn
                            navController.navigate("Register")
                        }
                )
            }
        }
    }
}

@Composable
fun InputRow(title: String) {
    CustomTextField(placeholderText = title) // Truyền tiêu đề như placeholder
}

@Composable
fun CustomTextField(placeholderText: String) {
    var username by remember { mutableStateOf("") }
    TextField(
        value = username,
        onValueChange = { username = it },
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(text = placeholderText) // Văn bản placeholder được hiển thị bên trong
        }
    )
}

@Composable
fun InputRowPass(title: String) {
    PasswordTextField(placeholderText = title) // Truyền tiêu đề như placeholder
}

@Composable
fun PasswordTextField(placeholderText: String) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        placeholder = {
            Text(text = placeholderText) // Văn bản placeholder cho trường mật khẩu
        },
        trailingIcon = {
            val image = if (passwordVisible)
                painterResource(id = R.drawable.hide)
            else
                painterResource(id = R.drawable.view)
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = image, contentDescription = null, modifier = Modifier.size(20.dp))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController() // Khởi tạo navController giả
    LoginScreen(navController = navController)
}


