package com.example.minhalojinha.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minhalojinha.rota

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MesasList (navController: NavController){

    var bottomState by remember {
        mutableStateOf("mesa")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "MinhaLojinha",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight(600)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Carrinho",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Gray)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF626262)) {
                NavigationBarItem(
                    selected = bottomState == "cadeira",
                    onClick = {
                        navController.navigate(rota.cadeiras)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "cadeiras",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(text = "cadeiras") }
                )
                NavigationBarItem(
                    selected = bottomState == "mesas",
                    onClick = {
                        navController.navigate(rota.mesa)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "tables",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(text = "mesas") }
                )
                NavigationBarItem(
                    selected = bottomState == "sofa",
                    onClick = {
                        navController.navigate(rota.sofa)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "sofa",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(text = "sofa") }
                )
            }
        }
    ) { innerPadding ->
        Text(text = "", modifier = Modifier.padding(innerPadding))
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "mesas List")
        }
    }
}