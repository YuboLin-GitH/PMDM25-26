package com.example.intentslogin

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.intentslogin.ui.theme.IntentsLoginTheme

class Pantalla2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentsLoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {

    Box(modifier=modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Column {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            TextField(value = "", onValueChange = {}, label = {Text("Nombre")})
            TextField(value = "", onValueChange = {}, label = {Text("Password")})
            val result = remember { mutableStateOf<Bitmap?>(null) }
            val launcher =
                rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
                    result.value = it
                }
            Button(onClick = { launcher.launch() }) { Text(text = "Take a picture") }

            result.value?.let { image ->
                Image(image.asImageBitmap(), null, modifier = Modifier.fillMaxWidth())
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    IntentsLoginTheme {
        Greeting2("Android")
    }
}