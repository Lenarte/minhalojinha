package com.example.minhalojinha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minhalojinha.ui.theme.MinhaLojinhaTheme
import com.example.minhalojinha.view.ChairsList
import com.example.minhalojinha.view.SofaList
import com.example.minhalojinha.view.TablesList




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinhaLojinhaTheme () {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    route = Graph.ROOT,
                    startDestination = Graph.CHAIRS
                ) {
                    composable (route = Graph.CHAIRS) {
                        ChairsList(navController = navController)
                    }
                    composable (route = Graph.TABLES) {
                        TablesList(navController = navController)
                    }
                    composable (route = Graph.SOFA) {
                        SofaList(navController = navController)
                    }
                }
            }
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val CHAIRS = "chairs_graph"
    const val TABLES = "tables_graph"
    const val SOFA = "sofa_graph"
}

