package com.example.ui_imperativavsdeclarativa

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityxml : AppCompatActivity() {
    var contador=0
    lateinit var etiqueta: TextView
    lateinit var boton: Button
    private val miviewModel: MiViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activityxml)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        inicializar_componentes()

      //  sin_viewmodel()


        conviewmodel()
    }

    private fun sin_viewmodel() {
        boton.setOnClickListener {
            contador++
            etiqueta.text="Contador:$contador"
        }
    }

    private fun inicializar_componentes() {
        etiqueta=findViewById<TextView>(R.id.textView2)
        etiqueta.text="Contador:$contador"
        boton=findViewById<Button>(R.id.button_sumar)
    }

    private fun conviewmodel() {
       //Defino un observador, de tal forma cuando cambia el valor de count
        miviewModel.count.observe(this){
            etiqueta.text="Contador:${it}"
        }

        //Defino el listener del button
        boton.setOnClickListener {
            miviewModel.increment()
            Log.i("INFO","ENTRA DENTRO DEL CLICK")
        }


    }
}