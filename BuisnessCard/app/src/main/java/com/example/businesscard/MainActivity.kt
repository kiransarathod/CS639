package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD8EFD3) // Light green background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD8EFD3))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top section - logo, name, title
        LogoSection()
        Spacer(modifier = Modifier.height(40.dp))
        // Bottom section - contact info
        ContactInfoSection()
    }
}

@Composable
fun LogoSection() {
    val image = painterResource(id = R.drawable.android_logo) // Add android_logo to drawable folder
    Image(
        painter = image,
        contentDescription = "Android Logo",
        modifier = Modifier
            .size(100.dp)
            .background(Color(0xFF073042))
            .padding(16.dp)
    )
    Text(
        text = "Kiran Rathod",
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier.padding(top = 16.dp)
    )
    Text(
        text = "Android Developer | Student",
        fontSize = 18.sp,
        color = Color(0xFF006400),
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun ContactInfoSection() {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        ContactRow(icon = Icons.Filled.Call, info = "+1 (123) 456-7890")
        ContactRow(icon = Icons.Filled.Share, info = "@AndroidDev")
        ContactRow(icon = Icons.Filled.Email, info = "kiransarathod@gmail.com")
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, info: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006400)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = info, fontSize = 16.sp)
    }
}
