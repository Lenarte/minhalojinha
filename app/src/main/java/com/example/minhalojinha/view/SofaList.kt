package com.example.minhalojinha.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.minhalojinha.model.Sofa
import com.example.minhalojinha.rota
import com.example.minhalojinha.ui.theme.*

//@OptIn(ExperimentalMaterial3Api:

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SofaList(navController: NavController) {

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
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
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
                    selected = bottomState == "sofa",
                    onClick = {
                        navController.navigate(rota.sofa)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Sofá",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(text = "Sofá") }
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
            val sofasList: MutableList<Sofa> = mutableListOf(
                Sofa(
                    imagem = R.drawable.telinha,
                    titulo = "Sofá Moderno",
                    descricao = "Sofá de tecido resistente",
                    preco = "R$ 2000"
                ),
                Sofa(
                    imagem = R.drawable.telinha,
                    titulo = "Sofá de Couro",
                    descricao = "Feito com couro legítimo",
                    preco = "R$ 3500"
                ),
                Sofa(
                    imagem = R.drawable.telinha,
                    titulo = "Sofá Retrátil",
                    descricao = "Conforto e praticidade",
                    preco = "R$ 2500"
                ),
                Sofa(
                    imagem = R.drawable.telinha,
                    titulo = "Sofá de Veludo",
                    descricao = "Acabamento de luxo",
                    preco = "R$ 4000"
                )
            )

            itemsIndexed(sofasList) { position, _ ->
                val sofa = sofasList[position]

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
                            painter = painterResource(id = sofa.imagem!!),
                            contentDescription = null,
                            alignment = Alignment.Center,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .width(200.dp)
                                .height(100.dp)
                        )
                        Text(
                            text = sofa.titulo!!,
                            color = BLACK,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                        )
                        Text(
                            text = sofa.descricao!!,
                            color = MEDIUM_GRAY,
                            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = sofa.preco!!,
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
