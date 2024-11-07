package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thuctap_fe.R
import com.example.thuctap_fe.navigation.Screen

@Composable
fun MainScreen(navCtrl: NavController = rememberNavController()) {
    var selected by remember { mutableStateOf(Screen.Home.route) }
    val navController = rememberNavController()
    var name by remember { mutableStateOf("GiapDQ") }

    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 15.dp, end = 15.dp)
                    .padding(WindowInsets.statusBars.asPaddingValues())
            ) {
                Text(
                    text = "Chào " + if (name.isNotEmpty()) name else "bạn",
                    fontSize = 26.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    color = Color.Black
                )

                IconButton(onClick = {
                    navCtrl.navigate(Screen.Profile.route)
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
        },
        bottomBar = {
            Box(
                contentAlignment = Alignment.Center
            ) {

                BottomAppBar(
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .height(120.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color("#FDF6DF".toColorInt()), Color("#FF9382".toColorInt()))
                            )
                        )
                ) {
                    // home
                    IconButton(
                        onClick = {
                            selected = Screen.Home.route
                            navController.navigate(Screen.Home.route) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Trang chủ",
                                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                                fontSize = 20.sp,
                                style = TextStyle(
                                    brush = Brush.horizontalGradient(
                                        if (selected == Screen.Home.route) listOf(
                                            Color("#FDC890".toColorInt()),
                                            Color("#FF9382".toColorInt())
                                        ) else listOf(
                                            Color.White,
                                            Color.White
                                        )
                                    )
                                )
                            )
                            if (selected == Screen.Home.route) Dot()
                        }
                    }


                    // option
                    IconButton(
                        onClick = {
                            selected = Screen.Option.route
                            navController.navigate(Screen.Option.route) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Tùy chọn",
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                                color = if (selected == Screen.Option.route) Color("#FF9382".toColorInt()) else Color.White
                            )
                            if (selected == Screen.Option.route) Dot()
                        }
                    }
                }
                IconButton(
                    onClick = {
                        navCtrl.navigate(Screen.CreateQuestion.route)
                    },
                    modifier = Modifier
                        .offset(y = (-60).dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color("#FDC890".toColorInt()), Color("#FF9382".toColorInt()))
                            ),
                            shape = CircleShape
                        ),
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.Home.route) {
                Home(navCtrl)
            }
            composable(Screen.Option.route) {
                OptionScreen(navCtrl)
            }
        }
    }
}


@Composable
fun Dot() {
    Image(
        painter = painterResource(id = R.drawable.dot_icon),
        contentDescription = "",
        modifier = Modifier.size(8.dp)
    )
}

@Composable
@Preview
fun preview() {
    MainScreen()
}
