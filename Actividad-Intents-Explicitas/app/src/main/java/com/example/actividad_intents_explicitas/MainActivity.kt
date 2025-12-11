package com.example.actividad_intents_explicitas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.actividad_intents_explicitas.ui.theme.ActividadIntentsExplicitasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActividadIntentsExplicitasTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(Color.Cyan)) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val contexto = LocalContext.current
    var valor_text by remember { mutableStateOf("") }
    Box(modifier= modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column {
            TextField(value = valor_text,
                onValueChange = {valor_text = it},
                label = {Text("Nombre")})
            Button(onClick = {
                val intent = Intent(contexto, SegundadActividad::class.java)
                intent.putExtra("nombre",valor_text)
                intent.putExtra("edad",44)
                contexto.startActivity(intent)
            }, modifier= modifier.padding(top = 8.dp)) {
                Text(
                    text = "Hello $name!",
                    modifier = modifier
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActividadIntentsExplicitasTheme {
        Greeting("Android")
    }
}