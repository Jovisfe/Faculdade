package com.example.feriados

import java.time.LocalDate

data class Feriado(
    var nome: String,
    var data: LocalDate,
    var tipo: String,
    var estado: String? = null,
    var municipio: String? = null
)