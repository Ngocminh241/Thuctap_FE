package com.example.thuctap_fe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.thuctap_fe.R


@Composable
fun CreatingQuestionScreen(navController: NavController? = null) {

    var answer1 by remember {
        mutableStateOf("")
    }
    var answer2 by remember {
        mutableStateOf("")
    }
    var answer3 by remember {
        mutableStateOf("")
    }
    var answer4 by remember {
        mutableStateOf("")
    }

    var status1 by remember {
        mutableStateOf(false)
    }
    var status2 by remember {
        mutableStateOf(false)
    }
    var status3 by remember {
        mutableStateOf(false)
    }
    var status4 by remember {
        mutableStateOf(false)
    }


    var question by remember {
        mutableStateOf("")
    }
    var showDialog by remember { mutableStateOf(false) }

    var editingAnswer by remember { mutableStateOf(0) }


    //danh sách màu nền đáp án
    val listColor = listOf(
        listOf(Color("#DB5D6E".toColorInt()), Color("#DC2840".toColorInt())),
        listOf(Color("#5C7BD4".toColorInt()), Color("#3A5FCC".toColorInt())),
        listOf(Color("#D4B55F".toColorInt()), Color("#D3A114".toColorInt())),
        listOf(Color("#5E994A".toColorInt()), Color("#359215".toColorInt())),
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
            }
        },
        content = { paddingValues ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(10.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    if (showDialog) {
                        AddDialog(
                            onDismiss = { showDialog = false },
                            value = if (editingAnswer == 1) answer1 else if (editingAnswer == 2) answer2 else if (editingAnswer == 3) answer3 else answer4,
                            onValueChange = {
                                if (editingAnswer == 1) answer1 = it
                                else if (editingAnswer == 2) answer2 = it
                                else if (editingAnswer == 3) answer3 = it
                                else answer4 = it
                            },
                            trangThai = if (editingAnswer == 1) status1 else if (editingAnswer == 2) status2 else if (editingAnswer == 3) status3 else status4,
                            dapAnDung = {
                                if (editingAnswer == 1) {
                                    status1 = !status1
                                    if (status1) {
                                        status2 = false
                                        status3 = false
                                        status4 = false
                                    }
                                } else if (editingAnswer == 2) {
                                    status2 = !status2
                                    if (status2) {
                                        status1 = false
                                        status3 = false
                                        status4 = false
                                    }
                                } else if (editingAnswer == 3) {
                                    status3 = !status3
                                    if (status3) {
                                        status1 = false
                                        status2 = false
                                        status4 = false
                                    }
                                } else {
                                    status4 = !status4
                                    if (status4) {
                                        status1 = false
                                        status2 = false
                                        status3 = false
                                    }
                                }
                            }

                        )
                    }

                    Card(
                        onClick = {},
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .background(Color.Red)
                                .padding(20.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "", tint = Color.White)
                            Text("Thêm ảnh", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        value = question,
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        onValueChange = { question = it },
                        placeholder = {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.widthIn(250.dp)
                            ) {
                                Text(
                                    text = "Nhập câu hỏi",
                                    color = Color.Gray,
                                    fontSize = 20.sp,
                                )
                            }
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color("#d6e0fc".toColorInt()),
                                        Color("#bacbff".toColorInt())
                                    )
                                ),
                                shape = RoundedCornerShape(10.dp) // Add shape if needed
                            )
                            .widthIn(300.dp)
                            .heightIn(70.dp)
                            .padding(top = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    Box {
                        Answer(answer1, {
                            showDialog = true
                            editingAnswer = 1
                        }, listColor[0])
                        if (status1) {
                            Image(
                                painter = painterResource(id = R.drawable.correct_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Box {
                        Answer(answer2, {
                            showDialog = true
                            editingAnswer = 2
                        }, listColor[1])
                        if (status2) {
                            Image(
                                painter = painterResource(id = R.drawable.correct_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Box {
                        Answer(answer3, {
                            showDialog = true
                            editingAnswer = 3
                        }, listColor[2])
                        if (status3) {
                            Image(
                                painter = painterResource(id = R.drawable.correct_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Box {
                        Answer(answer4, {
                            showDialog = true
                            editingAnswer = 4
                        }, listColor[3])
                        if (status4) {
                            Image(
                                painter = painterResource(id = R.drawable.correct_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }


                }
                IconButton(
                    onClick = {
                        showDialog = true
                    },
                    modifier = Modifier
                        .background(
                            color = Color("#0541b9".toColorInt()),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "", tint = Color.White)
                }
            }
        })
}

@Composable
fun Answer(
    value: String,
    onClick: () -> Unit,
    color: List<Color>
) {

    Button(
        onClick = onClick,
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
                    colors = color
                ),
                shape = RoundedCornerShape(10.dp) // Add shape if needed
            )
    ) {
        Text(
            text = value.ifEmpty { "Nhập câu trả lời" },
            color = Color.White,
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.nunito_bold))
        )
    }


}

@Composable
fun AddDialog(
    onDismiss: () -> Unit = {},
    value: String,
    onValueChange: (String) -> Unit,
    dapAnDung: () -> Unit = {},
    trangThai: Boolean = false
) {

    var status by remember { mutableStateOf(false) }
    var nameCheck by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.padding(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column {
                    OutlinedTextField(
                        value = value,
                        onValueChange = onValueChange,
                        label = { Text("Đáp án") },
                        placeholder = { Text("Nhập đáp án") },
                        isError = nameCheck,
                        supportingText = {
                            if (nameCheck) {
                                Text(
                                    "Không được để trống",
                                    color = Color.Red
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = trangThai,
                                onClick = dapAnDung,
                                role = Role.Checkbox
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = trangThai,
                            onCheckedChange = null
                        )

                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(text = "Đáp án đúng")
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun show() {
    CreatingQuestionScreen()
}