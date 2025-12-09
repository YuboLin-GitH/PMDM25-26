package com.example.ejemplopoo

import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var  misPinner : Spinner
    var tipos_vehiculos=arrayOf("Camion","Auto","Moto")

    fun simularConduccion(v : Conducible){
        // Invocar a arrancar
        v.arrancar()
        // Si el objeto v es Vehiculo
        if(v is Vehiculo) v.arrancar()
        // Invocar a detener
        v.detener()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        misPinner=findViewById<Spinner>(R.id.spinner)
        findViewById<Button>(R.id.button).setOnClickListener {
           var miVehiculo: Vehiculo?=null


            //1º Averiguar que elemento hay seleccionado en el spinner
            when(misPinner.selectedItem.toString()){
                "Camion"->//Instancio el objeto de la clase camion
                    miVehiculo= Camion("Scania","D140",2010,150,10.0)
                "Moto"-> miVehiculo=Motocicleta("Suzuki","S530",2010,260)
                "Auto"-> miVehiculo=Auto("Renault","Koleo",2020,220,4)
            }
            // Mostrar en un AleartDialogo todos los mensajes que se
            // generan con la invocacion de los métodos arrancar ,acelerar y etener

            // Definimos el objeto que nos  permitira definir el dialogo
            var builderDialog= AlertDialog.Builder(this)
            builderDialog.apply {
                setTitle(misPinner.selectedItem.toString())

                setMessage("${miVehiculo?.arrancar()}  ${miVehiculo?.acelerar()}  ${miVehiculo?.detener()}")

                setPositiveButton("Aceptar", { d, which ->
                    if(which == DialogInterface.BUTTON_POSITIVE)
                    {
                    d.dismiss()
                    }
                })

            }
            //Muestro el AlertDialog
            builderDialog.create().show()

        }

        configurar_spinner()

    }
    private fun configurar_spinner() {
        //Definir adaptador que define los datos que se muestran en el spinner y la apariencia
        var miAdaptador = ArrayAdapter<String>( this,
            android.R.layout.simple_spinner_item,
            tipos_vehiculos)
        //Defino la vista que va a tener el spinner cuando se despliega
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_item)

        //Asigno el spinner el adaptador
        misPinner.adapter=miAdaptador
    }
}