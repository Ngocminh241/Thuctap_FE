package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.thuctap_fe.R
import com.example.thuctap_fe.navigation.Screen

//import androidx.navigation.NavController
//import fpoly.giapdqph34273.asm_ph34273_kot104.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController) {
    preview(navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun preview(navController: NavController? = null) {
    manHinhChao(navController)
}

@Composable
fun manHinhChao(navController: NavController? = null) {
    val backgroundPainter: Painter = painterResource(id = R.drawable.anh_man_hinh_chao)

    Box(
        modifier = Modifier.fillMaxSize()
            .navigationBarsPadding()


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
                    top = 180.dp,
                    bottom = 25.dp
                )
        ) {


            Text(
                text = "Learning with",
                fontSize = 40.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                modifier = Modifier
                    .padding(bottom = 1.dp) // Padding between title and input fields
                    .align(Alignment.CenterHorizontally) // Center text horizontally
            )
            Text(
                text = "children",
                fontSize = 40.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                modifier = Modifier
                    .padding(bottom = 16.dp) // Padding between title and input fields
                    .align(Alignment.CenterHorizontally) // Center text horizontally
            )

            Spacer(modifier = Modifier.height(20.dp))
            val image: Painter =
                painterResource(id = R.drawable.nguoidocsach) // replace with your image resource
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
                        text = "BẮT ĐẦU",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) // Pushes the following column to the bottom


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly, // Distributes space evenly between buttons
                    verticalAlignment = Alignment.CenterVertically

                )  {
                    Row(

                    ) {

                    TextButton(
                        onClick = {
                            navController?.navigate(Screen.Register.route)

                        },
                        modifier = Modifier.padding(end = 4.dp)// Reduce padding between buttons
                    ) {
                        Text(
                            text = "Đăng ký",
                            fontSize = 20.sp,
                            color = Color.White, // Customize the color
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    }
                    TextButton(
                        onClick = {
                                navController?.navigate(Screen.Login.route)

                        },
                                modifier = Modifier.padding(start = 4.dp)
                    ) {
                        Text(
                            text = "Đăng nhập",
                            fontSize = 20.sp,
                            color = Color.White, // Customize the color
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    }
                }
            }
        }
    }
}
}
