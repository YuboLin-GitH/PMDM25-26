package com.example.crearusuarios

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crearusuarios.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mibinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Instancio el binding
        mibinding = ActivityMainBinding.inflate(layoutInflater)

        //Vinculo con la vista
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarSpinner()
        mibinding.button.setOnClickListener {
            //Recojo el valor introducido en editText nombre,
            //si no se ha introducido nada devuelve null
            val nom = mibinding.nombreEditText.text.toString().takeIf { it.isNotBlank() }
            //Recojo el valor de edad si se puede convertir a un entero,
            //En otro caso retorna null
            val edad =
                mibinding.edadEditText.text.toString().takeIf { it.isNotBlank() }?.toIntOrNull()

            //Creo el usuario si el campo nombre no es null

            nom?.let { nombre_input->
                //Entra por aqui si nom es no nulo
                //let es una función que espera código a ejecutarse
                //como una expresión lambda la cual tiene un parametro
                //que representa el propio elemento que invoca a let
                edad?.let { edadinput->
                    //Entra por aqui si edad es no nulo
                    //Creamos el Usuario
                    val usuario= Usuario(nombre_input,edadinput, mibinding.spinner.selectedItem as TipoUsuario)
                    Toast.makeText(this,"ALTA CORRECTA", Toast.LENGTH_LONG).show()

                }

            }

        }
    }

     fun inicializarSpinner() {
        var miadaptador= ArrayAdapter<TipoUsuario>(this,android.R.layout.simple_spinner_item,
            arrayOf(TipoUsuario.Normal, TipoUsuario.Administrador))
        mibinding.spinner.adapter=miadaptador



        }

    }
