package com.lucasvieira.todolist

import java.text.SimpleDateFormat
import java.util.*

private val locale = Locale("pt", "BR")

fun Date.format() :String{
    return SimpleDateFormat("dd/MM/yyyy", locale).format(this)
}