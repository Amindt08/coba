@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.sellmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sellmate.ui.theme.SellMateTheme

class profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SellMateTheme {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header dengan logo dan nama aplikasi
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            // Gantikan dengan Image jika Anda memiliki logo sebagai resource
            Icon(
                Icons.Default.Person, // Placeholder untuk logo
                contentDescription = "Logo",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "SELL MATE",
                color = Color(0xFFFDBA3B), // Warna kuning emas
                style = MaterialTheme.typography.titleLarge
            )
        }

        // Informasi saldo pengguna
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF8DA7CC))
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Istya Yulia Amesti",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Text(
                    text = "Saldo : Rp. 550.000,-",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }
        }

        // Section "Settings"
        Text(
            text = "Settings",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Menampilkan nama, email, dan password
        ProfileItem(label = "Nama", value = "Istya Yulia Amesti", backgroundColor = Color(0xFFEADAB7))
        ProfileItem(label = "Email", value = "istyacantik54@gmail.com", backgroundColor = Color(0xFF8DA7CC))
        ProfileItem(label = "Password", value = "IstyaCantik4538!", backgroundColor = Color(0xFFEADAB7))

        Spacer(modifier = Modifier.height(32.dp))

        // Tombol logout
        Button(
            onClick = { /* Handle logout */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA7CC))
        ) {
            Text(
                text = "logout",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String, backgroundColor: Color) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        color = backgroundColor,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "$label : $value",
            modifier = Modifier.padding(16.dp),
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    SellMateTheme {
        ProfileScreen()
    }
}