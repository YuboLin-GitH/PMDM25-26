package com.example.ui_imperativavsdeclarativa

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_imperativavsdeclarativa.ui.theme.Purple40
import com.example.ui_imperativavsdeclarativa.ui.theme.UI_ImperativavsDeclarativaTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Llamadas a funciones Composables
            UI_ImperativavsDeclarativaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                        Greeting(

                            Modifier.padding(innerPadding)
                        )

                }
            }
        }
    }
}



@Composable
fun Greeting(modificador: Modifier = Modifier) {

        //Variable que se recuerda "remember" su valor en las diferentes invocaciones de Greeting
        //Greeting se ejecuta cada vez que haya una modificación en la UI (reactivo)
        //mutableStateOf define una variable observable a cambios, se la llama variable reactiva
        //Va a implicar que va a ejecutar el código donde esta definida Greeting cuando se produzca
        //un cambio en su valor
        //rememberSaveable guarda el valor usando por "debajo" SaveInstanceState ante destrucciones
        //de la activity
        //by va a permitir acceder al valor de count directamente, delegación de propiedades
        //sin by declaramos count:rememberSaveable{....} y para acceder al valor tenemos
       //que usar la propiedad value.

       var count by rememberSaveable { mutableStateOf(0) }

        

    Box(modifier = modificador.fillMaxSize().background(Color.Cyan), contentAlignment = Alignment.Center) {

            Column() {
                Text(fontSize = 24.sp, fontWeight = FontWeight.Bold, text="Contador: ${count}")

                Button(modifier = Modifier.padding(top=16.dp),onClick = { count++ }) {
                    //Recomposición inteligente, esto no se recompone porque no depende de count
                    Text(fontSize = 20.sp,text="Sumar")
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Imagen"
                    )
                }
            }




    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UI_ImperativavsDeclarativaTheme {
        Greeting()
    }
}