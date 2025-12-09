package com.example.simulacionexamen_kotlin

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.method.KeyListener
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simulacionexamen_kotlin.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var mibinding: ActivityMainBinding
    lateinit var mireloj: CountDownTimer

    var  minutos =3
    var segundos =59
    var objpalabras= Juego_de_Palabras()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mibinding= ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarComponentes()
        inicializarReloj()

        finalizarJuego()

        comprobarPuntos()

    }

    private fun comprobarPuntos() {
        mibinding.btComprobar.setOnClickListener {
            val respuesta = mibinding.etpalabra.text.toString()
            val correcta = objpalabras.palabraOriginal
            val longitud = correcta.length


            val puntosGanados = when (objpalabras.tipoCambio) {
                0 -> minOf(longitud, 10)          // Faltan caracteres
                1 -> minOf(longitud + 1, 10)      // Cambio de vocal + descolocada
                2 -> minOf((longitud * 2) / 3, 10) // Posición del carácter
                3 -> minOf(longitud / 2 + 3, 10)  // Tu cambio inventado
                else -> 1
            }
            val puntosPerdidos = 2  // máximo permitido por examen

            if (respuesta.equals(correcta, ignoreCase = true)) {
                objpalabras.puntos += puntosGanados
                Toast.makeText(this, "¡Correcto! +$puntosGanados puntos", Toast.LENGTH_SHORT).show()
            } else {
                objpalabras.puntos -= puntosPerdidos
                Toast.makeText(this, "Incorrecto -$puntosPerdidos puntos", Toast.LENGTH_SHORT).show()
            }

            mibinding.tvPuntos.text = "Puntos: ${objpalabras.puntos}"
            comprobarCondicionFinal()
            nuevaRondaJuego()
        }
    }

    private fun inicializarReloj() {
        //Instancio el objeto
        mireloj = object : CountDownTimer(180000,1000) {
            override fun onFinish() {
                finalizarJuego()
            }

            override fun onTick(millisUntilFinished: Long) {
                minutos = (millisUntilFinished / 1000 / 60).toInt()
                segundos = ((millisUntilFinished / 1000) % 60).toInt()

                mibinding.tiempo.text = String.format("%d:%02d", minutos, segundos)
            }
        }
    }

    private fun inicializarComponentes() {

        //Definimos el listaener para el boton comenzar juego
        mibinding.btJugar.setOnClickListener {
            //Habilitamos el editText
            mibinding.etpalabra.isEnabled=true
            mibinding.btComprobar.isEnabled=true
            mibinding.btJugar.isEnabled=false
            mibinding.ivResultado.visibility= View.INVISIBLE

            //Mostrarmos la palabra transformada
            //Generamos un numero aleatorio entre 0 y 3 para la definir
            //el modo de transformar la palabra
            var num = Random.nextInt(0, 4)


            val nuevaPalabra = objpalabras.obtener_Palabra()
            objpalabras.palabraOriginal = nuevaPalabra
            objpalabras.tipoCambio = num

            mibinding.tvpista.text= objpalabras.obtener_Pista(num)
            var palabraCambiada:String=""
            when(num){
                //transformacion faltan caracteres
                0 -> palabraCambiada = nuevaPalabra.transformar(Random.nextBoolean()){ c, pos ->
                    if (Random.nextBoolean()) '_' else c
                }
                1 -> palabraCambiada = nuevaPalabra.transformar(true){ c, pos ->
                    when(c) {
                        'a' -> 'e'; 'e' -> 'i'; 'i' -> 'o'; 'o' -> 'u'; 'u' -> 'a'; else -> c
                    }
                }
                2 -> palabraCambiada = nuevaPalabra.transformar(false){ c, pos ->
                    if (pos % 2 == 0) (c.lowercaseChar().code - 'a'.code + 1).toString()[0] else c
                }
                3 -> palabraCambiada = nuevaPalabra.transformar(false){ c, pos ->
                    c.uppercaseChar()
                }
                else -> palabraCambiada = nuevaPalabra
            }
            mibinding.tvpalabraModificada.text = palabraCambiada
            mibinding.etpalabra.text.clear() // 清空输入框
            mireloj.start()

        }
    }

    private fun finalizarJuego() {
        mibinding.etpalabra.isEnabled = false
        mibinding.btComprobar.isEnabled = false
        var mensaje = ""
        if (objpalabras.puntos > 50) {
            mensaje = "¡Has ganado la partida!"
            mibinding.ivResultado.setImageResource(R.drawable.ic_launcher_background)
            mibinding.ivResultado.visibility = View.VISIBLE    // 显示胜利图片
        } else if (objpalabras.puntos < 0) {
            mibinding.ivResultado.setImageResource(R.drawable.ic_launcher_foreground)
            mensaje = "Has perdido, puntuación negativa"
            mibinding.ivResultado.visibility = View.VISIBLE    // 显示失败图片
        } else {
            mibinding.ivResultado.setImageResource(R.drawable.ic_launcher_foreground)
            mensaje = "Tiempo terminado"
            mibinding.ivResultado.visibility = View.VISIBLE

        }
        Handler(mainLooper).postDelayed({
            resetUI()
        }, 1500)
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }


    private fun comprobarCondicionFinal() {
        if (objpalabras.puntos > 50 || objpalabras.puntos < 0) {
            mibinding.etpalabra.isEnabled = false
            mibinding.btComprobar.isEnabled = false
            finalizarJuego()
            mibinding.btJugar.isEnabled = true
        }
    }

    private fun resetUI() {
        // Reiniciar puntos
        objpalabras.puntos = 2
        mibinding.tvPuntos.text = "Puntos: ${objpalabras.puntos}"

        // Reset entrada
        mibinding.etpalabra.text.clear()
        mibinding.etpalabra.isEnabled = false

        // Botones
        mibinding.btComprobar.isEnabled = false
        mibinding.btJugar.isEnabled = true

        // Palabra y pista vacías
        mibinding.tvpalabraModificada.text = ""
        mibinding.tvpista.text = ""

        // Imagen resultado (ocultar y borrar)
        mibinding.ivResultado.setImageDrawable(null)
        mibinding.ivResultado.visibility = View.INVISIBLE

        // Reloj
        mibinding.tiempo.text = "3:00"
        mireloj.cancel()
    }


    private fun nuevaRondaJuego() {
        // Obtener nueva palabra original y tipo de transformación
        val nuevaPalabra = objpalabras.obtener_Palabra()
        objpalabras.palabraOriginal = nuevaPalabra
        objpalabras.tipoCambio = (0..3).random()

        // Mostrar pista
        mibinding.tvpista.text = objpalabras.obtener_Pista(objpalabras.tipoCambio)

        // Aplicar transformación
        val palabraCambiada = when (objpalabras.tipoCambio) {
            0 -> nuevaPalabra.transformar(false){ c, _ -> if (Random.nextBoolean()) '_' else c }
            1 -> nuevaPalabra.transformar(true){ c, _ ->
                when (c.lowercaseChar()) {
                    'a' -> 'e'; 'e' -> 'i'; 'i' -> 'o'; 'o' -> 'u'; 'u' -> 'a'
                    else -> c
                }
            }
            2 -> nuevaPalabra.transformar(false){ c, pos ->
                if (pos % 2 == 0) (c.lowercaseChar().code - 'a'.code + 1).toString()[0] else c
            }
            3 -> nuevaPalabra.transformar(false){ c, _ -> c.uppercaseChar() }
            else -> nuevaPalabra
        }

        // Mostrar nueva palabra transformada
        mibinding.tvpalabraModificada.text = palabraCambiada

        // Limpiar input
        mibinding.etpalabra.text.clear()
    }
}