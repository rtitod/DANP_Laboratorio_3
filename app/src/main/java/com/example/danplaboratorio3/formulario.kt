package com.example.danplaboratorio3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text


@Composable
fun formulario(
    nombre: String,
    fun_nombre: (String) -> Unit,
    fecha: String,
    fun_fecha: (String) -> Unit,
    tiposangre: String,
    fun_tiposangre: (String) -> Unit,
    telefono: String,
    fun_telefono: (String) -> Unit,
    correo: String,
    fun_correo: (String) -> Unit,
    monto: String,
    fun_monto: (String) -> Unit,
    booleditando: Boolean,
    fun_booleditando: () -> Unit,
    textbutton: String,
    fun_textbutton: (String) -> Unit,
    listaparticipantes: MutableList<Participante>,
    fun_resetcampos: () -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { fun_nombre(it) },
        label = { Text(text = "Nombres completos:") },
        enabled = !booleditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fecha,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { fun_fecha(it) },
        label = { Text(text = "Fecha de inscripcion:") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = tiposangre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { fun_tiposangre(it) },
        label = { Text(text = "Tipo de sangre:") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = telefono,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        onValueChange = { fun_telefono(it) },
        label = { Text(text = "Teléfono:") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = correo,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        onValueChange = { fun_correo(it) },
        label = { Text(text = "Correo:") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = monto,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        onValueChange = { fun_monto(it) },
        label = { Text(text = "Monto pagado:") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
        onClick = {
            if (booleditando) {
                editar_participante(nombre, fecha, tiposangre, telefono, correo, monto, listaparticipantes)
                fun_textbutton("Añadir participante")
                fun_booleditando()
            } else {
                agregar_participante(nombre, fecha, tiposangre, telefono, correo, monto, listaparticipantes)
            }
            fun_resetcampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textbutton
        )
    }
}