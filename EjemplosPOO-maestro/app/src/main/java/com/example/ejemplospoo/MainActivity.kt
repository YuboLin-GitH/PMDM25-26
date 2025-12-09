package com.example.ejemplospoo

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()






        setContentView(R.layout.activity_main)
        var imagen:ImageView=findViewById<ImageView>(R.id.imageView)
        imagen.cargarImagen("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png")
    //   mostrar_mensaje("Mensaje", Toast.LENGTH_LONG)

        //Referencio un objeto editText
        var mitexto=findViewById<EditText>(R.id.edittext)
        //Asocio un escuchador a ese editText a traves de
    // la función de extensión definida en Extensiones.kt
        mitexto.despues_cambio_texto {

            mostrar_mensaje(it)
        }


    }
}