package com.example.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfield.ui.theme.TextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextFieldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    HelloContent(Modifier.padding(it))
                }
            }
        }
    }
}




@Composable
private fun HelloContent(miModifier: Modifier = Modifier) {
    var mitext by rememberSaveable { mutableStateOf("") }

    Column(modifier = miModifier.padding(16.dp)) {
        Text(
            text = "Hello : $mitext",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = mitext,
            onValueChange = { textocambiado ->
                mitext = textocambiado
            },
            label = { Text("Name") }
        )
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HelloContenPreview() {
    TextFieldTheme {
        HelloContent()
    }
}