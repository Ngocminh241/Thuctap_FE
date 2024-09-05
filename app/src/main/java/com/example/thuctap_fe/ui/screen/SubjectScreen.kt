package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.thuctap_fe.R
import com.example.thuctap_fe.navigation.Screen

@Composable
fun SubjectScreen(navController: NavController? = null) {

    //danh sách môn học
    val listSubject = listOf(
        "Bài 1",
        "Bài 2",
        "Bài 3",
        "Bài 4",
        "Bài 5",
        "Bài 6",
        "Bài 7",
        "Bài 8",
        "Bài 9",
        "Bài 10"
    )

    //danh sách ảnh
    val listImage = listOf(
        R.drawable.bai1_bg,
        R.drawable.bai2_bg,
        R.drawable.bai3_bg,
        R.drawable.bai4_bg,
        R.drawable.bai5_bg,
        R.drawable.bai6_bg,
        R.drawable.bai7_bg,
    )

    val levelname = "Mầm non"
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
                        text = levelname,
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

                LazyColumn {
                    itemsIndexed(listSubject) { index, subject ->
                        val imageIndex = index % listImage.size
                        Card(
                            onClick = {
                                navController?.navigate(Screen.Play.route)
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Transparent,
                            ),
                            modifier = Modifier
                                .width(350.dp)
                                .height(90.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                            ) {
                                Image(
                                    painter = painterResource(id = listImage[imageIndex]),
                                    contentDescription = null,
                                    modifier = Modifier.size(width = 350.dp, height = 90.dp),
                                )

                                Text(
                                    text = subject,
                                    style = TextStyle(
                                        color = Color.White,
                                        fontSize = 30.sp,
                                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }


            }

        })
}

@Preview
@Composable
private fun show() {
    SubjectScreen()
}