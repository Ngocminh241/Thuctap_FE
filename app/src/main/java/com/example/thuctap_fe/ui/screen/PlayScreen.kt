package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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

@Composable
fun PlayScreen(navController: NavController? = null) {

    //danh sách đáp án
    val listAnswer = listOf(
        "Con ngựa",
        "Con báo",
        "Con trâu",
        "Con gà"
    )

    val question by remember {
        mutableStateOf("Đây là con gì")
    }

    //danh sách màu nền đáp án
    val listColor = listOf(
        listOf(Color("#DB5D6E".toColorInt()),Color("#DC2840".toColorInt())),
        listOf(Color("#5C7BD4".toColorInt()),Color("#3A5FCC".toColorInt())),
        listOf(Color("#D4B55F".toColorInt()),Color("#D3A114".toColorInt())),
        listOf(Color("#5E994A".toColorInt()),Color("#359215".toColorInt())),
    )
    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
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
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(5.dp),
                ) {
                    Text(
                        text = "3/20",
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

                Image(
                    painter = painterResource(id = R.drawable.anhngua),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(200.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = question,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                )

                Spacer(modifier = Modifier.height(40.dp))

                LazyColumn {
                    itemsIndexed(listAnswer) { index, answer ->
                        val imageIndex = index % listColor.size
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
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
                                        colors = listColor[imageIndex]
                                    ),
                                    shape = RoundedCornerShape(10.dp) // Add shape if needed
                                )
                        ) {
                            Text(
                                text = answer,
                                color = Color.White,
                                fontSize = 26.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_bold))
                            )
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
    PlayScreen()
}