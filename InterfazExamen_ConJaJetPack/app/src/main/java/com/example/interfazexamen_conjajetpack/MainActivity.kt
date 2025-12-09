package com.example.interfazexamen_conjajetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.interfazexamen_conjajetpack.ui.theme.InterfazExamen_ConJaJetPackTheme
import com.example.interfazexamen_conjajetpack.ui.theme.Purple80
import com.example.interfazexamen_conjajetpack.ui.theme.TopBarColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterfazExamen_ConJaJetPackTheme {
                ListaCompraScreen({})
            }
        }
    }
}



@Composable
fun ListaCompraScreen(onAgregarClick: () -> Unit) {
    Scaffold(
        topBar = { com.example.interfazexamen_conjajetpack.ListaCompraTopBar() },
        floatingActionButton = { AgregarFab(onClick = onAgregarClick) }
    ) { it: PaddingValues ->
        it
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaCompraTopBar() {
    TopAppBar(
        title = { Text(text = "LISTA DE LA COMPRA") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = TopBarColor,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
fun AgregarFab(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick,
        contentColor = MaterialTheme.colorScheme.onPrimary) {

    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InterfazExamen_ConJaJetPackTheme {
        ListaCompraScreen({})
    }
}