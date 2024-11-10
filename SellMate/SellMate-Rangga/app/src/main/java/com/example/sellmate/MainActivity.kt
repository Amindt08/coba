@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.sellmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sellmate.ui.theme.SellMateTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SellMateTheme {
                // Menyiapkan NavController untuk navigasi antar layar
                val navController = rememberNavController()

                // Setup NavHost untuk menentukan layar yang akan ditampilkan
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(navController) // Pass navController ke HomeScreen
                    }
                    composable("apayaw") {
                        ProfileScreen() // Pindah ke ProfileScreen
                    }
                }
            }
        }
    }
}
@Composable
fun HomeScreen(navController: NavController) {
    val selectedIndex = remember { mutableStateOf(0) }
    val amin21 = remember { mutableStateOf(0) }
    val amin12 = remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SearchBar(navController) },  // Pass navController ke SearchBar
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle add product */ },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Product")
            }
        },
        bottomBar = {
            BottomNavigationBar(
                selectedIndex = selectedIndex.value,
                onItemSelected = { selectedIndex.value = it }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Selamat Datang Di Aplikasi SellMate")
        }
    }
}

@Composable
fun SearchBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = "",
            onValueChange = { /* Handle search text change */ },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            placeholder = { Text("Search") },
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Search Icon")
            },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFEADAB7),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        IconButton(onClick = {
            navController.navigate("profile")  // Navigasi ke ProfileScreen
        }) {
            Icon(Icons.Filled.Person, contentDescription = "Profile Icon")
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = "",
            onValueChange = { /* Handle search text change */ },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            placeholder = { Text("Search") },
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Search Icon")
            },
            shape = RoundedCornerShape(20.dp), // Membuat sudut melengkung
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFEADAB7),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        IconButton(onClick = { /* Handle profile click */ }) {
            Icon(Icons.Filled.Person, contentDescription = "Profile Icon")
        }
    }
}
@Composable
fun BottomNavigationBar(selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color(0xFF8DA7CC)
    ) {
        val selectedIconColor = Color.Black // Warna hitam untuk ikon yang dipilih
        val unselectedIconColor = Color(0xFF4A4A4A) // Warna abu-abu untuk ikon yang tidak dipilih agar tetap terlihat

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home",
                    tint = if (selectedIndex == 0) selectedIconColor else unselectedIconColor // Menentukan warna ikon
                )
            },
            label = { Text("Home") },
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.ShoppingBag,
                    contentDescription = "Products",
                    tint = if (selectedIndex == 1) selectedIconColor else unselectedIconColor // Menentukan warna ikon
                )
            },
            label = { Text("Products") },
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.History,
                    contentDescription = "History",
                    tint = if (selectedIndex == 2) selectedIconColor else unselectedIconColor // Menentukan warna ikon
                )
            },
            label = { Text("History") },
            selected = selectedIndex == 2,
            onClick = { onItemSelected(2) }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SellMateTheme {
        HomeScreen(
            navController = TODO()
        )
    }
}