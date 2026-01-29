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


data class Elemento (val texto:String, var estado_check:Boolean)


@Composable
fun MiLazyColumn(){
    val context = LocalContext.current
    // val list by remember { mutableStateListOf(MutableList(100)){"Element $it"} }  // no funciona
    //var lista = remember {List<Elemento>(100) {Elemento( "Elemento $it", estado_check = false) }.toMutableStateList()}
    var lista by remember { mutableStateOf(List(100){Elemento( "Elemento $it", estado_check = false)}) }


    //(1..100).map{"Element $it"}
    LazyColumn {
        itemsIndexed (lista, key= {index,element-> element.hashCode()}){index, element ->



            //Variable para almacenar el estado del checkbox

            var estado_check by remember { mutableStateOf(false) }

            Row (modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()){
                Text("Indice: $index ${element.texto}")
                Spacer(
                    modifier= Modifier.weight(1f)
                )
                Checkbox(element.estado_check,
                    onCheckedChange = {
                        //Aqui tendremos que provocar un cambio en la lista para que se recomponga la vista
                        //Crear una nueva lista con todos los elementos igual que la lista original,
                        // excepto el valor del atributo estado_check del elemento clickado

                        lista = lista.map {item ->
                            if (element == item){
                                item.copy(estado_check=!estado_check)
                            }else{
                                item
                            }
                        }

                        element.estado_check = !element.estado_check})
                Button(onClick = {
                    Toast.makeText(context,"Has eliminado ${element.texto}", Toast.LENGTH_SHORT).show()
                    lista = lista.toMutableList().apply { remove(element) }

                }) {
                    Text("Aceptar")
                }
            }

        }
    }
}