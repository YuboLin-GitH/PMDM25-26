package com.example.ejemplo_ciclovida

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.ejemplo_ciclovida.databinding.SegundaActivityBinding

class SegundaActividad : AppCompatActivity() {
    var botonpulsado = true
    var valor=0
    lateinit var micheck: CheckBox
    lateinit var boton:Button
    lateinit var imagen:ImageView
    lateinit var texto:TextView
    lateinit var edittext:TextView
    lateinit var mitoolBar:Toolbar

/** Callback que es obligatorio implementar en una actvidad
    - Se ejecuta al principio de la creación de la actividad
    - Se usa para:
        - establecer el layaout a la actividad
        - Inicializar objetos de la actividad
        - Instanciar las vistas
        - Establecer los escuchadores
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.segunda_activity)


        initComponents(savedInstanceState)

    Log.i("CicloVida","Se ejecuta OnCreate, se crea la actividad")


    }
    /** Cuando la actividad  se vuelve visible al usuario */

    override fun onStart(){
        super.onStart()
        Log.i("CicloVida","Se ejecuta OnStart, la actividad se hace visible")
    }
/** La actividad tiene el foco ***/
    override fun onResume() {
        super.onResume()
        Log.i("CicloVida","Se ejecuta onResume, la actividad tiene el foco")
    }


    /**** La actividad pierde el foco principal pero es visible por detras ****/
    override fun onPause() {
        super.onPause()
        Log.i("CicloVida","Se ejecuta OnPause, la actividad pierde el foco principal, pero es visible")
    }

    /** La actividad deja de ser visible, pasa a 2º plano, aunque ocupa espacio en memoria **/
    override fun onStop() {
        super.onStop()
        Log.i("CicloVida","Se ejecuta onStop, la actividad ya no es visible,")
    }
    /** La actividad es finalizada (finish) o esta siendo destruida por el sistema para liberar espacio de memoria **/
    override fun onDestroy() {
        super.onDestroy()
        Log.i("CicloVida","Se ejecuta onDestroy, la actividad de destruye de memoria")
    }

    //Método que se invoca cuando temporalmente la actividad se destruye
    //Guardamos el estado de los componentes para que cuando se
    //vuelva crear la vista se establezcan los elementos
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("estado",botonpulsado)
    }

    fun initComponents(estado:Bundle?)
    {

        //Obtengo la toolBar
        this.mitoolBar=findViewById(R.id.mitoolbar)
        //Establezco la toolbar
        setSupportActionBar(this.mitoolBar)
        this.micheck=findViewById<CheckBox>(R.id.checkBox)
        //No se guarda el valor cuando se destruye la actividad
        this.micheck.isSaveEnabled=false
        this.boton=findViewById(R.id.button)
        this.imagen=findViewById(R.id.compartir)
        this.texto=findViewById(R.id.textView)
        this.edittext=findViewById(R.id.editText)
        this.texto.text=valor.toString()
        this.imagen.setOnClickListener{
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                   "Comparto el valor del textfield:${texto.text} "
                )
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)

            try {
                ContextCompat.startActivity(this, shareIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                   "Compartir no disponible",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        this.boton.setOnClickListener {
            /*val builderdialog=AlertDialog.Builder(this)
            builderdialog.setMessage("Mensaje de prueba")
            builderdialog.setTitle("Titulo")
                .setPositiveButton("Aceptar"){dialogo,boton->
                    Toast.makeText(this,"BOTON ACEPTAR PULSADO",Toast.LENGTH_SHORT).show()

                }
                .setNegativeButton("Cancelar"){dialogo,boton->
                    Toast.makeText(this,"BOTON CANCELAR PULSADO",Toast.LENGTH_SHORT).show()
                }
            val dialogo:AlertDialog=builderdialog.create()
            dialogo.show() */
            valor++
            texto.text=valor.toString()
        }


        if(estado!=null){
            //En este caso pongo el estado que tenian los componentes
                    Log.i("Ciclo Vida","El bundle no es vacio,")

        }

    }


    fun pulsaboton(vista: View) {
        this.botonpulsado=!this.botonpulsado
        this.micheck.setChecked(this.botonpulsado)


    }
}

