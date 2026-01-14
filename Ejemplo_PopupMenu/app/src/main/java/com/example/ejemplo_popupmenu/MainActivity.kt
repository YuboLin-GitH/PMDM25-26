package com.example.ejemplo_popupmenu

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplo_popupmenu.ui.theme.Ejemplo_PopupMenuTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo_PopupMenuTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GmailPopupMenu(
                        modificador = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GmailPopupMenu(modificador: Modifier = Modifier) {
    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modificador.fillMaxSize()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        androidx.compose.foundation.layout.Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("menu esta aqui")


            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Opciones"
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            DropdownMenuItem(
                text = { Text("Responder a todos") },
                onClick = {
                    expanded = false
                    Toast.makeText(context, "Responder a todos", Toast.LENGTH_SHORT).show()
                }
            )


            DropdownMenuItem(
                text = { Text("Reenviar") },
                onClick = {
                    expanded = false
                    Toast.makeText(context, "Reenviar", Toast.LENGTH_SHORT).show()
                }
            )

            DropdownMenuItem(
                text = { Text("Destacar") },
                onClick = {
                    expanded = false
                    Toast.makeText(context, "Destacar", Toast.LENGTH_SHORT).show()
                }
            )

            DropdownMenuItem(
                text = { Text("Imprimir") },
                onClick = {
                    expanded = false
                    Toast.makeText(context, "Imprimir", Toast.LENGTH_SHORT).show()
                }
            )

            DropdownMenuItem(
                text = { Text("Marcar los mensajes como no leídos d..") },
                onClick = {
                    expanded = false
                    Toast.makeText(context, "Marcar los mensajes como no leídos d..", Toast.LENGTH_SHORT).show()
                }
            )
            DropdownMenuItem(
                text = { Text("Bloquear a Diego de OpenWebinars") },
                onClick = {
                    expanded = false
                    Toast.makeText(context, "Bloquear a Diego de OpenWebinars", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejemplo_PopupMenuTheme {
        GmailPopupMenu()
    }
}