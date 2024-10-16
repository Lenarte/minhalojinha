package com.example.minhalojinha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minhalojinha.ui.theme.MinhaLojinhaTheme
import com.example.minhalojinha.view.CadeirasList
import com.example.minhalojinha.view.SofaList
import com.example.minhalojinha.view.MesasList
import com.example.minhalojinha.view.LoginScreen
import com.example.minhalojinha.view.RegistroScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinhaLojinhaTheme() {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    route = rota.rota,
                    startDestination = rota.login // Define a tela de login como a inicial
                ) {
                    composable(route = rota.login) {
                        LoginScreen(navController = navController)
                    }
                    composable(route = rota.registro) {
                        RegistroScreen(navController = navController)
                    }
                    composable(route = rota.cadeiras) {
                        CadeirasList(navController = navController)
                    }
                    composable(route = rota.mesa) {
                        MesasList(navController = navController)
                    }
                    composable(route = rota.sofa) {
                        SofaList(navController = navController)
                    }
                }
            }
        }
    }
}

object rota {
    const val rota = "rota_rota"
    const val cadeiras = "cadeiras_rota"
    const val mesa = "mesa_rota"
    const val sofa = "sofa_rota"
    const val login = "login_rota" // Rota da tela de login
    const val registro = "registro_rota" // Rota da tela de registro
}
