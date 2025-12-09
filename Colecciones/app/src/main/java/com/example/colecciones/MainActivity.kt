package com.example.colecciones

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class Persona(var nombre: String, var edad: Int)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val miLista: List<Persona> = listOf(Persona("Juan", 33), Persona("Javier", 22))

        miLista.forEach {
            Log.i("LISTA", "$it")
        }
        //Difino una lista mutable
        val miListaMutable: MutableList<Persona> = miLista as MutableList<Persona>

        miListaMutable.add(Persona("Angel", 21))

        for (elemento in miListaMutable){
            //
        }


    }
}