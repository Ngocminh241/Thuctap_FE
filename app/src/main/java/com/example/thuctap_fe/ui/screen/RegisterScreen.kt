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

@Composable
fun RegisterScreen(navController: NavController) {
    var isClicked by remember { mutableStateOf(false) } // Biến trạng thái để theo dõi khi nhấn vào "Đăng Ký"

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.manhinhdangky),
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

        // Foreground content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center, // Căn giữa theo chiều dọc
            horizontalAlignment = Alignment.CenterHorizontally // Căn giữa theo chiều ngang
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "ĐĂNG KÝ",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Đảm bảo căn giữa theo chiều ngang
                )
            }
            InputRow(title = "Nhập Email")
            InputRowPass(title = "Nhập Mật Khẩu")
            InputRowPass(title = "Nhập Lại Mật Khẩu")
            Button(
                onClick = {

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
                    text = "Đăng Ký",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                )
            }
            Row(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(
                    text = "Bạn đã có tài khoản ?  ",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_variable_fontwght))

                )
                Text(
                    modifier = Modifier
                        .wrapContentSize() // Giới hạn vùng nhấn chỉ bao quanh text
                        .clickable {
                            isClicked = !isClicked // Thay đổi trạng thái khi nhấn
                            navController.navigate("Login")
                        },
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.nunito_bold))
                            )

                        ) {
                            append("Đăng Nhập")
                        }
                    },
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    val navController = rememberNavController() // Khởi tạo navController giả
    RegisterScreen(navController = navController)
}