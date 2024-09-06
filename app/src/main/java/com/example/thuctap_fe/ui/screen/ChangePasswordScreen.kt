package com.example.thuctap_fe.ui.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thuctap_fe.R

@Composable
fun ChangePasswordScreen(navController: NavController) {
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var currentPasswordVisible by remember { mutableStateOf(false) }
    var newPasswordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
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
                text = "Thay đổi mật khẩu ",
                fontSize = 26.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                color = Color.Black
            )
        }
    }
        },
        content = { paddingValues ->

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Nhập Mật Khẩu Hiện Tại
            PasswordInputField(
                label = "Mật khẩu hiện tại",
                password = currentPassword,
                onPasswordChange = { currentPassword = it },
                passwordVisible = currentPasswordVisible,
                onVisibilityChange = { currentPasswordVisible = !currentPasswordVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nhập Mật Khẩu Mới
            PasswordInputField(
                label = "Mật khẩu mới",
                password = newPassword,
                onPasswordChange = { newPassword = it },
                passwordVisible = newPasswordVisible,
                onVisibilityChange = { newPasswordVisible = !newPasswordVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Xác Nhận Mật Khẩu Mới
            PasswordInputField(
                label = "Xác nhận mật khẩu mới",
                password = confirmPassword,
                onPasswordChange = { confirmPassword = it },
                passwordVisible = confirmPasswordVisible,
                onVisibilityChange = { confirmPasswordVisible = !confirmPasswordVisible }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Nút Cập Nhật Mật Khẩu
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(Color("#FDC890".toColorInt()), Color("#FF9382".toColorInt()))
                        ),
                        shape = RoundedCornerShape(30.dp) // Add shape if needed
                    )
            ) {
                Button(
                    onClick = {
                        when {
                            currentPassword.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Vui lòng nhập mật khẩu hiện tại",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            newPassword.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Vui lòng nhập mật khẩu mới",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            confirmPassword != newPassword -> {
                                Toast.makeText(
                                    context,
                                    "Mật khẩu xác nhận không khớp",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            else -> {
                                Toast.makeText(
                                    context,
                                    "Mật khẩu đã được thay đổi thành công",
                                    Toast.LENGTH_SHORT
                                ).show()
                                // Thực hiện logic cập nhật mật khẩu ở đây
                                navController.popBackStack() // Quay lại màn hình trước
                            }
                        }
                    },

                        // To ensure button text is centered on the gradient background

//                    modifier = Modifier.fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, // Make the button's color transparent
                        contentColor = Color.White // Set the text color
                    )
                ) {
                    Text(
                        text = "Cập Nhật Mật Khẩu"
                    )
                }
            }
        }
    }
        }
    )
}

@Composable
fun PasswordInputField(
    label: String,
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onVisibilityChange: () -> Unit
) {
    val paddingStart = 16.dp // Padding start value for both placeholder and text input

    Column {
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 5.dp,
                    shape = RoundedCornerShape(35.dp),
                    brush = Brush.horizontalGradient(
                        listOf(Color("#FDC890".toColorInt()), Color("#FF9382".toColorInt()))
                    )
                )
                .padding(start = paddingStart), // Add padding to TextField
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
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible) painterResource(id = R.drawable.hide) else painterResource(id = R.drawable.view)
                IconButton(onClick = onVisibilityChange) {
                    Icon(painter = image, contentDescription = null, modifier = Modifier.size(20.dp))
                }
            },
            placeholder = {
                Text(
                    text = label,
                    color = Color.Gray,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChangePasswordScreen() {
    // Mock NavController for preview
    val navController = rememberNavController()
    ChangePasswordScreen(navController)
}