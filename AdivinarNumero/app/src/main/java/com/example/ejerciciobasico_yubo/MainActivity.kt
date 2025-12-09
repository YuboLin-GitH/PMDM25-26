package com.example.ejerciciobasico_yubo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejerciciobasico_yubo.databinding.ActivityMainBinding
import kotlin.random.Random
class MainActivity : AppCompatActivity() {
    private lateinit var  mibinding: ActivityMainBinding

    private var numInt = 5
    private var numMax = 10
    private var numOculto = 0
    private var intentos = 0
    private var juegoActivo = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mibinding = ActivityMainBinding.inflate(layoutInflater)


        enableEdgeToEdge()
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mibinding.numIntEditText.setText(numInt.toString())
        mibinding.numMaxEditText.setText(numMax.toString())

        setupButtonListeners()
    }


    private fun setupButtonListeners() {
        // 配置按钮
        mibinding.botonConfigurar.setOnClickListener {
            configurarJuego()
        }

        // 开始游戏按钮
        mibinding.botonJugar.setOnClickListener {
            iniciarJuego()
        }

        // 检查按钮
        mibinding.botonConprobar.setOnClickListener {
            comprobarAdivinanza()
        }

        // 退出按钮
        mibinding.botonSalir.setOnClickListener {
            finish()
        }
    }



    private fun configurarJuego(){
        val nuevoNumInt = mibinding.numIntEditText.text.toString().toIntOrNull()
        val nuevoNumMax = mibinding.numMaxEditText.text.toString().toIntOrNull()

        if (nuevoNumInt != null && nuevoNumInt > 0 && nuevoNumMax != null && nuevoNumMax > 0){
            numInt = nuevoNumInt
            numMax = nuevoNumMax
            Toast.makeText(this, "Configuración actualizada", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, introduce valores válidos", Toast.LENGTH_SHORT).show()
        }
    }



    private fun iniciarJuego() {

        numOculto = Random.nextInt(numMax + 1)
        intentos = 0
        juegoActivo = true

        mibinding.numEditText.text.clear()
        Toast.makeText(
            this,
            "Juego iniciado! Adivina el número entre 0 y $numMax",
            Toast.LENGTH_LONG
        ).show()
    }


    private fun comprobarAdivinanza() {
        if (!juegoActivo) {
            Toast.makeText(this, "Primero pulsa Jugar para empezar", Toast.LENGTH_SHORT).show()
            return
        }
        val adivinanza = mibinding.numEditText.text.toString().toIntOrNull()

        if (adivinanza == null) {
            Toast.makeText(this, "Por favor, introduce un número válido", Toast.LENGTH_SHORT).show()
            return
        }
        intentos++

        when {
            adivinanza == numOculto -> {
                // 猜对了
                mibinding.resultadoTextView.text = "¡Has ganado! Has necesitado $intentos intentos"
                juegoActivo = false
            }
            intentos >= numInt -> {
                // 用完所有尝试次数
                mibinding.resultadoTextView.text = "¡Perdiste! El número oculto era $numOculto"
                juegoActivo = false
            }
            adivinanza < numOculto -> {
                // 猜小了
                mibinding.resultadoTextView.text = "El número oculto es mayor. Intentos restantes: ${numInt - intentos}"
            }
            else -> {
                // 猜大了
                mibinding.resultadoTextView.text = "El número oculto es menor. Intentos restantes: ${numInt - intentos}"
            }
        }

        // 清空输入框以便下一次猜测
        mibinding.numEditText.text.clear()



    }


}