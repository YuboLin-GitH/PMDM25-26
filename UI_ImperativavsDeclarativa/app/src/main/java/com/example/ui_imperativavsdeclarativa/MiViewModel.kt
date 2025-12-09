package com.example.ui_imperativavsdeclarativa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MiViewModel: ViewModel() {
    // MutableLiveData interna
    private val _count = MutableLiveData(0)

    // LiveData pública (solo lectura desde la UI por ser LiveData, no Mutable
    // y tiene la misma dirección de memoria de _count, con lo que cualquier
    // cambio en _count significa cambio en count
    val count: LiveData<Int> = _count


    fun increment(incremento:Int=1) {
        _count.value+=incremento
    }
}
