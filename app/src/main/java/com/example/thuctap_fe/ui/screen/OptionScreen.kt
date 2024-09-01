package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.thuctap_fe.R

@Composable
fun OptionScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            NutBam(
                title = "Đổi mật khẩu",
                firstColor = Color("#FDC890".toColorInt()),
                secondColor = Color("#FF9382".toColorInt())
            )

            Spacer(modifier = Modifier.height(20.dp))

            NutBam(
                title = "Đăng xuất",
                firstColor = Color("#CD868F".toColorInt()),
                secondColor = Color("#DC2840".toColorInt())
            )

        }
    }
}

@Composable
fun NutBam(title: String, firstColor: Color, secondColor: Color, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent // Set container color to transparent
        ),
        modifier = Modifier
            .widthIn(
                min = 300.dp,
            )
            .heightIn(
                min = 70.dp
            )
            .background(
                brush = Brush.horizontalGradient(
                    listOf(firstColor, secondColor)
                ),
                shape = RoundedCornerShape(10.dp) // Add shape if needed
            )
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.nunito_bold))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Show() {
    OptionScreen()
}