package com.example.danplaboratorio3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text


@Composable
fun infoparticipante(
    fun_nombre: (String) -> Unit,
    fun_fecha: (String) -> Unit,
    fun_tiposangre: (String) -> Unit,
    fun_telefono: (String) -> Unit,
    fun_correo: (String) -> Unit,
    fun_monto: (String) -> Unit,
    fun_textbutton: (String) -> Unit,
    fun_booleaneditando: (Boolean) -> Unit,
    participante: Participante,
    fun_borrarparticipante: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            Arrangement.Center
        ) {
            Text(
                text = participante.nombre,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = participante.fecha,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = participante.tiposangre,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = participante.telefono,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = participante.correo,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = participante.monto,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        fun_nombre(participante.nombre)
                        fun_fecha(participante.fecha)
                        fun_tiposangre(participante.tiposangre)
                        fun_telefono(participante.telefono)
                        fun_correo(participante.correo)
                        fun_monto(participante.monto)
                        fun_textbutton("Editar participante")
                        fun_booleaneditando(true)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Editar"
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        fun_borrarparticipante(participante.nombre)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Borrar"
                    )
                }
            }
        }
    }
}