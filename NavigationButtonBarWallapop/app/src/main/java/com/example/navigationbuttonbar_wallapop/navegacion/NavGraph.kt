package com.example.ejemplonavegacioncompose.navegacion


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.ejemplonavegacioncompose.ui.componentes.BottomBar
import com.example.navigationbuttonbar_wallapop.ui.pantallas.BuzonScreen
import com.example.navigationbuttonbar_wallapop.ui.pantallas.FavoritosScreen
import com.example.navigationbuttonbar_wallapop.ui.pantallas.InicioScreen
import com.example.navigationbuttonbar_wallapop.ui.pantallas.ProfileScreen
import com.example.navigationbuttonbar_wallapop.ui.pantallas.VenderScreen


//Aqui se define el NavHost y
//toda la navegación
@Composable
fun NavGraph() {
    //Defino el el controlador de navegación
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Inicio,
            modifier = Modifier.padding(padding)
        ) {
            //Defino las rutas, en este caso como String
            composable<Inicio> {

                InicioScreen()
            }
            composable<Favoritos> {
                FavoritosScreen()
            }

            composable<Vender> {
                VenderScreen()
            }
            composable<Buzon> {
                BuzonScreen()
            }
            composable<Perfil> {
                ProfileScreen()
            }


        }
    }
}
