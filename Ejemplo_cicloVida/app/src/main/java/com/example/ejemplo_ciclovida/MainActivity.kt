package com.example.ejemplo_ciclovida

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Se crea un objeto lateinit de cada vista
    lateinit var boton_segundaactividad:Button
    lateinit var boton_terceraactividad:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Metodo que suele instanciar a las vistas
        inicializarComponents()

        //Método para establecer escuchadores a las vistas


        }

    private fun inicializarComponents() {
        boton_segundaactividad=findViewById<Button>(R.id.button2)
        boton_terceraactividad=findViewById<Button>(R.id.button3)

        boton_segundaactividad.setOnClickListener {
          var  mi_intencion=Intent(this,SegundaActividad::class.java)
            startActivity(mi_intencion)
        }

        boton_terceraactividad.setOnClickListener {
            var mi_intencion=Intent(this,TerceraActividad::class.java)
            startActivity(mi_intencion)
        }
    }

}
