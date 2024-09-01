package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.thuctap_fe.R
import com.example.thuctap_fe.model.Grade

@Composable
fun Home() {
    val listProduct = listOf(
        Grade("1", "Mầm non", R.drawable.mam_non_icon, R.drawable.anh_mau_giao),
        Grade("2", "Lớp 1", R.drawable.lop_1_icon, R.drawable.anh_lop_1),
        Grade("3", "Lớp 2", R.drawable.lop_2_icon, R.drawable.anh_lop_2),
        Grade("4", "Lớp 3", R.drawable.lop_3_icon, R.drawable.anh_lop_3),
        Grade("5", "Lớp 4", R.drawable.lop_4_icon, R.drawable.anh_lop_4),
        Grade("6", "Lớp 5", R.drawable.lop_5_icon, R.drawable.anh_lop_5),
    )
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 25.dp,
                end = 16.dp,
                bottom = 16.dp
            )

        ) {
            items(listProduct) { model ->
                ItemGrid(model)
            }
        }
    }
}

@Composable
fun ItemGrid(model: Grade) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
            ),
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
//                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = model.gradeBackground),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp)
                )

                Image(
                    painter = painterResource(id = model.gradeIcon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .offset(
                            x = 50.dp,
                            y = (-50).dp
                        )
                )

                Text(
                    text = model.gradeName,
                    modifier = Modifier.offset(
                        y = 40.dp
                    ),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Home()
}