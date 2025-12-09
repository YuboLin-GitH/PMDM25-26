package com.example.enumcolores

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Color.BLACK
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


//Defino una clase que implementa la interace que gestiona el evento
//de seleccionar elementos en un spinner
class escuchadorSpinner: AdapterView.OnItemSelectedListener {
    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
    //Aqui se pone el codigo que queremos que se ejecute cuando se cambia en un elemento del spinner
        (parent?.parent as View).setBackgroundColor(((parent as Spinner).selectedItem as Colores).retornarColor())

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }



}

enum class Colores{ROJO,VERDE,AZUL,NEGRO;
        //Definimos una funcion que nos retorna
    //El objeto Color en función del valor que tenga ese objeto Colores
        fun retornarColor(): Int {
             var micolor:Int
            when(this){
                ROJO-> micolor=(Color.RED)
                AZUL-> micolor=(Color.BLUE)
                VERDE-> micolor=(Color.GREEN)
                NEGRO-> micolor= (Color.BLACK)
            }
            return micolor
        }
}

class MainActivity : AppCompatActivity() {
    lateinit var miSpinner : Spinner
    lateinit var miSpinner_texto : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializar_spinner()

    }


    private fun inicializar_spinner() {
        this.miSpinner=findViewById<Spinner>(R.id.spinner)
        this.miSpinner_texto=findViewById<Spinner>(R.id.spinner2)


        var miAdaptador_spinertexto = ArrayAdapter<Float>(this, android.R.layout.simple_spinner_item, arrayOf(12f,18f,28f,48f))
        miAdaptador_spinertexto.setDropDownViewResource(android.R.layout.simple_spinner_item)
        miSpinner_texto.adapter=miAdaptador_spinertexto


        miSpinner_texto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                findViewById<TextView>(R.id.textView).textSize=(parent as Spinner).selectedItem as Float
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }



        var miAdaptador = ArrayAdapter<Colores>( this,
            android.R.layout.simple_spinner_item,
            Colores.values()
        )
        //Defino la vista que va a tener el spinner cuando se despliega
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_item)

        //Asigno el spinner el adaptador
        miSpinner.adapter=miAdaptador


        // Configuro el evento de seleccionar un elemento en el spinner
        //Declaro un objeto de la clase que implementa la interface
         var miObjetoEscuchador: escuchadorSpinner = escuchadorSpinner()
        miSpinner.onItemSelectedListener= miObjetoEscuchador




    }
}