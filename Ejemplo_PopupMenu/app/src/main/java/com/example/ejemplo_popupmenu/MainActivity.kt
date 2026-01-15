package com.example.ejemplo_popupmenu

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejemplo_popupmenu.ui.theme.Ejemplo_PopupMenuTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo_PopupMenuTheme {
                Scaffold(
                    topBar = {
                        MiTopBar(modifier = Modifier, onclic_opcion = { text ->
                                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                            }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Text(
                        text = "Contenido de la app",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun GmailPopupMenu( click_opcion: (String)-> Unit) {


    var menu_expanded by remember { mutableStateOf(false) }


    Box {
        IconButton(onClick = { menu_expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Opciones")
        }
        DropdownMenu(
            expanded = menu_expanded,
            onDismissRequest = { menu_expanded = false }
        ) {

            DropdownMenuItem(

                text = { Text("Responder a todos") },
                onClick = {
                    menu_expanded = false
                    click_opcion("Responder a todos")
                }
            )


            DropdownMenuItem(
                text = { Text("Reenviar") },
                onClick = {
                    menu_expanded = false
                    click_opcion("Reenviar")
                }
            )

            DropdownMenuItem(
                text = { Text("Destacar") },
                onClick = {
                    menu_expanded = false
                    click_opcion("Destacar")
                }
            )

            DropdownMenuItem(
                text = { Text("Imprimir") },
                onClick = {
                    menu_expanded = false
                    click_opcion("Imprimir")
                }
            )

            DropdownMenuItem(
                text = { Text("Marcar los mensajes como no leídos d..") },
                onClick = {
                    menu_expanded = false
                    click_opcion("Marcar los mensajes como no leídos d..")
                }
            )
            DropdownMenuItem(
                text = { Text("Bloquear a Diego de OpenWebinars") },
                onClick = {
                    menu_expanded = false
                    click_opcion("Bloquear a Diego de OpenWebinars")
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiTopBar(modifier: Modifier, onclic_opcion:(String)->Unit){
    TopAppBar(title = {},
        navigationIcon = {
            IconButton(onClick = {/*todo*/}) {
                Icon(imageVector = Icons.Default.ArrowBack,contentDescription = "Volver atrás") }
        }, actions = {
            IconButton(onClick = {}) {
                Icon(painter = painterResource(R.drawable.carpeta_flecha),contentDescription = "Perfil de usuario")
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Delete,contentDescription = "Eliminal")
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.MailOutline,contentDescription = "email")
            }
            GmailPopupMenu (click_opcion = onclic_opcion )

        }
    )
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejemplo_PopupMenuTheme {
        MiTopBar(modifier= Modifier){}
    }
}