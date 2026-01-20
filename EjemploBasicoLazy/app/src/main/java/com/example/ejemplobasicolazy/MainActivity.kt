package com.example.ejemplobasicolazy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplobasicolazy.ui.theme.EjemploBasicoLazyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploBasicoLazyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Pantalla(Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun Pantalla(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
    {

        Text(text = "ddddd", fontSize = 18.sp)

        Spacer(
            modifier= Modifier.padding(top = 8.dp)
        )
        MiLazyColumn()
    }
}


data class Elemento(val texto:String, var estado_check:Boolean)


@Composable
fun MiLazyColumn(){
    val context = LocalContext.current
    // val list by remember { mutableStateListOf(MutableList(100)){"Element $it"} }  // no funciona
    val list = remember {List<Elemento>(100) {Elemento( "Elemento $it", false) }.toMutableStateList()}



    //(1..100).map{"Element $it"}
    LazyColumn {
        itemsIndexed (list, key= {index,element-> element.hashCode()}){index, element ->
            Row (modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()){
                Text("Indice: $index ${element.texto}")
                Spacer(
                    modifier= Modifier.weight(1f)
                )
                Checkbox(checked = element.estado_check, onCheckedChange = {element.estado_check = !element.estado_check})
                Button(onClick = {
                    Toast.makeText(context,"Has eliminado $element", Toast.LENGTH_SHORT).show()
                    list.remove(element)
                }) {
                    Text("Aceptar")
                }
            }

        }
    }
}