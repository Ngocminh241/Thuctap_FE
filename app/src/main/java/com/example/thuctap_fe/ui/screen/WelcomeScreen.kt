package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.thuctap_fe.R
//import androidx.navigation.NavController
//import fpoly.giapdqph34273.asm_ph34273_kot104.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController) {
    preview(navController)
}

@Preview(showBackground = true)
@Composable
private fun preview(navController: NavController? = null) {
    manHinhChao(navController)
}

@Composable
fun manHinhChao(navController: NavController? = null) {
    val backgroundPainter: Painter = painterResource(id = R.drawable.anh_man_hinh_chao)

    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 40.dp,
                    end = 40.dp,
                    top = 250.dp,
                    bottom = 16.dp
                )
        ) {


            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Learning with children",
                fontSize = 40.sp,
                color = Color("#303030".toColorInt()),

                fontFamily = FontFamily(Font(R.font.nunito_bold))
            )

            Spacer(modifier = Modifier.height(20.dp))
            val image: Painter = painterResource(id = R.drawable.nguoidocsach) // replace with your image resource
            Image(
                painter = image,
                contentDescription = "Image Description",
                modifier = Modifier.size(150.dp) // You can adjust the size as needed
            )




            Spacer(modifier = Modifier.height(100.dp))

            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        Color("#242424".toColorInt())
                    ),
                    modifier = Modifier
                        .background(
                            Color("#242424".toColorInt()),
                            shape = RoundedCornerShape(4.dp)
                        )
                ) {
                    Text(
                        text = "Get Started",
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_variable_fontwght)),
                    )
                }
            }
        }
    }
}