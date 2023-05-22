package com.example.danplaboratorio3

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
          APPtheme {

                val listaParticipantes = remember { mutableStateListOf<Participante>() }

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        builder(listaParticipantes)
                    }
                }
            }
        }
    }
}

@Composable
fun builder(listaParticipantes: MutableList<Participante>) {

    var nombre by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var tiposangre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }
    var booleaneditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar participante") }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            formulario(
                nombre,
                {nombre = it},
                fecha,
                {fecha = it},
                tiposangre,
                {tiposangre = it},
                telefono,
                {telefono = it},
                correo,
                {correo = it},
                monto,
                {monto = it},
                booleaneditando,
                {booleaneditando = false},
                textButton,
                {textButton = it},
                listaParticipantes,
                {
                    nombre = ""
                    fecha = ""
                    tiposangre = ""
                    telefono = ""
                    correo = ""
                    monto = ""
                },
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(listaParticipantes) { participante ->

                        infoparticipante(
                            {nombre = it},
                            {fecha = it},
                            {tiposangre = it},
                            {telefono = it},
                            {correo = it},
                            {monto = it},
                            {textButton = it},
                            {booleaneditando = it},
                            participante,
                            { borrar_participante(it, listaParticipantes) }
                        )
                    }
                }
            }
        }
    }
}

fun agregar_participante(nombre: String, fecha: String, tiposangre:String, telefono:String, correo:String, monto:String, listaparticipantes: MutableList<Participante>) {
    listaparticipantes.add(Participante(nombre,fecha,tiposangre,telefono,correo,monto))
}

fun editar_participante(nombre: String, fecha: String, tiposangre:String, telefono:String, correo:String, monto:String, listaparticipantes: MutableList<Participante>) {
    listaparticipantes.forEach { participante ->
        if (participante.nombre == nombre) {
            participante.fecha = fecha
            participante.tiposangre = tiposangre
            participante.telefono = telefono
            participante.correo = correo
            participante.monto = monto
        }
    }
}

fun borrar_participante(nombre: String, listaparticipantes: MutableList<Participante>) {
    listaparticipantes.forEach { participante ->
        if (participante.nombre == nombre) {
            listaparticipantes.remove(participante)
        }
    }
}