package com.example.actividad_intents_explicitas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.actividad_intents_explicitas.ui.theme.ActividadIntentsExplicitasTheme

class SegundadActividad : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Obtengo la intent que abre esta 2 actividad
        val intent = intent
        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getIntExtra("edad",0)

        setContent {
            ActividadIntentsExplicitasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "$nombre",
                        edad = "$edad",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, edad: String, modifier: Modifier = Modifier) {
    Box(modifier=modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            text = "Hello $name tiene $edad años",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ActividadIntentsExplicitasTheme {
        Greeting2("Android", edad = "")
    }
}