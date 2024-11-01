package com.example.minhalojinha.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.minhalojinha.R
import com.example.minhalojinha.model.ItemVenda

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemVendaScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    var editItem: ItemVenda? by remember { mutableStateOf(null) }
    var itemList by remember { mutableStateOf(mutableListOf<ItemVenda>()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gerenciar Itens à Venda") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Gray)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                editItem = null
                showDialog = true
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Adicionar Item")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(itemList) { item ->
                    ItemCard(
                        item = item,
                        onEdit = {
                            editItem = it
                            showDialog = true
                        },
                        onDelete = {
                            itemList.remove(it)
                        }
                    )
                }
            }
        }
    }

    if (showDialog) {
        ItemVendaDialog(
            item = editItem,
            onDismiss = { showDialog = false },
            onSave = { newItem ->
                if (editItem == null) {
                    itemList.add(newItem) // Adiciona novo item
                } else {
                    itemList[itemList.indexOf(editItem)] = newItem // Edita item existente
                }
                showDialog = false
            }
        )
    }
}

@Composable
fun ItemCard(item: ItemVenda, onEdit: (ItemVenda) -> Unit, onDelete: (ItemVenda) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imagem),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(item.titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(item.descricao, fontSize = 14.sp)
                Text("Preço: ${item.preco}", fontSize = 16.sp, color = Color.Gray)
            }
            IconButton(onClick = { onEdit(item) }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar Item")
            }
            IconButton(onClick = { onDelete(item) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Excluir Item")
            }
        }
    }
}

@Composable
fun ItemVendaDialog(
    item: ItemVenda?,
    onDismiss: () -> Unit,
    onSave: (ItemVenda) -> Unit
) {
    var titulo by remember { mutableStateOf(item?.titulo ?: "") }
    var descricao by remember { mutableStateOf(item?.descricao ?: "") }
    var preco by remember { mutableStateOf(item?.preco ?: "") }
  //  var imagem by remember { mutableStateOf(item?.imagem ?: R.drawable.placeholder) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = if (item == null) "Adicionar Item" else "Editar Item") },
        text = {
            Column {
                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = descricao,
                    onValueChange = { descricao = it },
                    label = { Text("Descrição") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = preco,
                    onValueChange = { preco = it },
                    label = { Text("Preço") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Mostra a imagem atual ou um placeholder se estiver vazia
                //Image(
                    //painter = painterResource(id = imagem),
                  //  contentDescription = null,
                  //  modifier = Modifier.size(80.dp).align(Alignment.CenterHorizontally)
               // )
            }
        },
        confirmButton = {
            Button(
                onClick = {


                }
            ) { Text("Salvar") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancelar") }
        }
    )
}
