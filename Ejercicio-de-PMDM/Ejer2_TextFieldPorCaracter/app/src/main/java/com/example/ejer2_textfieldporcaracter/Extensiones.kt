package com.example.ejer2_textfieldporcaracter


import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText




fun EditText.despues_cambio_texto(listener:(String)->Unit)
{
    this.addTextChangedListener(object:TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
         //En este caso no se hace nada
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
           //En este caso no se hace nada
        }
        override fun afterTextChanged(s: Editable?) {
            listener(s.toString())
        }


    })


}