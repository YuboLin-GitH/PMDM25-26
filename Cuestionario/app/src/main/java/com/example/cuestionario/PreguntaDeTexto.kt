package com.example.cuestionario

enum class Dificultad{BAJA, MEDIA, ALTA}
data class PreguntaDeTexto(val textoPregunta:String, val respuesta:String, val dificultad: Dificultad)

data class PreguntaTrueFalse(val textoPregunta:String, val respuesta: Boolean,val diffUtil: Dificultad)

data class PreguntaAritmetica(val textoPregunta:String, val respuesta: Int,val diffUtil: Dificultad)

// Clase gen erica que engloba a todas las anteriores
data class Pregunta<T>(val textoPregunta: String, val  respuesta: T, val dificultad: Dificultad)