package com.example.circleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleAppUI()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CircleAppUI() {

    var radius by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF0F7FF)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Circle Area Calculator",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D47A1),
                modifier = Modifier.padding(top = 30.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Formula:  A = π × r²",
                fontSize = 18.sp,
                color = Color(0xFF1565C0),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.circle_image),
                contentDescription = "Circle",
                modifier = Modifier.size(160.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {

                Column(
                    Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    OutlinedTextField(
                        value = radius,
                        onValueChange = {
                            radius = it
                            error = if (radius.isNotEmpty() && !radius.matches(Regex("\\d+(\\.\\d+)?"))) {
                                "Only numbers allowed"
                            } else ""
                        },
                        label = { Text("Enter radius") },
                        isError = error.isNotEmpty(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    if (error.isNotEmpty()) {
                        Text(
                            text = error,
                            color = Color.Red,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            when {
                                radius.isEmpty() -> result = "⚠️ Please enter a radius"
                                error.isNotEmpty() -> result = "⚠️ Invalid input"
                                else -> {
                                    val r = radius.toDouble()
                                    val area = PI * r * r
                                    result = "Area: %.2f".format(area)
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2))
                    ) {
                        Text("Calculate", color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = result,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D47A1)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Enter radius to compute circle area instantly!",
                color = Color(0xFF0D47A1),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
