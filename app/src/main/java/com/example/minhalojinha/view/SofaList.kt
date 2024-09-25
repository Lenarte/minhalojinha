package com.example.minhalojinha.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minhalojinha.R
import com.example.minhalojinha.model.Cadeira
import com.example.minhalojinha.rota
import com.example.minhalojinha.ui.theme.BLACK
import com.example.minhalojinha.ui.theme.CardShapeList
import com.example.minhalojinha.ui.theme.LIGHT_GRAY
import com.example.minhalojinha.ui.theme.MEDIUM_GRAY

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SofaList (navController: NavController){

    var bottomState by remember {
        mutableStateOf("sofa")
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
                    IconButton(onClick = {  }) {
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
                            contentDescription = "mesas",
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(innerPadding)
        ) {
            var cadeirasList: MutableList<Cadeira> = mutableListOf(
                Cadeira(
                    imagem = R.drawable.telinha,
                    titulo = "mesa moderna",
                    descricao = "feita em madeira mdf",
                    preco = "R$ 700 "
                ),
                Cadeira(
                    imagem = R.drawable.telinha,
                    titulo = "mesa de marmore",
                    descricao = "marmore importado",
                    preco = "R$ 1700"
                ),
                Cadeira(
                    imagem = R.drawable.telinha,
                    titulo = "mesa de plastico",
                    descricao = "plastico de alta resistencia",
                    preco = "R$ 700"
                ),
                Cadeira(
                    imagem = R.drawable.telinha,
                    titulo = "mesa de aco inox",
                    descricao = "mesa de inox resistente",
                    preco = "R$ 1000"
                )
            )

            itemsIndexed(cadeirasList) { position, _ ->

                val imagem = cadeirasList[position].imagem
                val titulo = cadeirasList[position].titulo
                val descricao = cadeirasList[position].descricao
                val preco = cadeirasList[position].preco

                Card(
                    modifier = Modifier.padding(10.dp),
                    shape = CardShapeList.medium,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(17.dp)
                    ) {
                        Image(
                            painter = painterResource(id = imagem!!),
                            contentDescription = null,
                            alignment = Alignment.Center,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .width(200.dp)
                                .height(100.dp)
                        )
                        Text(
                            text = titulo!!,
                            color = BLACK,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                        )
                        Text(
                            text = descricao!!,
                            color = MEDIUM_GRAY,
                            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = preco!!,
                            color = LIGHT_GRAY,
                            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}