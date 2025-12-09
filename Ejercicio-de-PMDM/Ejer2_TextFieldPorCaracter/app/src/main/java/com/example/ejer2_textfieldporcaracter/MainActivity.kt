package com.example.ejer2_textfieldporcaracter

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val editText = findViewById<EditText>(R.id.editTextText)
        val textField = findViewById<TextView>(R.id.textView)

        // USO DE LA FUNCION DE EXTENCION
        editText.despues_cambio_texto { texto ->
            /*
            textField.text = caracteresIntroducidos(it)
             OTRA FORMA
            textField.text = "_*.repeat(cadena.length)*/

            var cadena=""
            for(a in texto){
                cadena+="_"
            }
            textField.text=cadena;

        }

    }
    /*
    fun caracteresIntroducidos(caracteres: String): String {
        val numCaracteres = caracteres.toString()
        var numGuiones = "";
        // SE USA UNTIL PARA EVITAR EL INDICE FUERA DEL RANGO
        for (i: Int in 0 until numCaracteres.length) {
            numGuiones += "_"
        }
        return numGuiones;
    }*/
}