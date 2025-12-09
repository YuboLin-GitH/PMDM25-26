package com.example.ejercicopoo_finaltema2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.ejercicopoo_finaltema2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mibinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mibinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root)


        val tipos = listOf("UsuarioNormal", "Administrador")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipos)
        mibinding.spinner.adapter = adapter


    }




}