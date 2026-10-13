package com.godsfa.mimayoredad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.godsfa.mimayoredad.R.id
import kotlin.toString

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(id.boton)
        val mensaje = findViewById<TextView>(id.mensaje)
        val edadVar = findViewById<EditText>(id.edad)
        val BotonSuma = findViewById<Button>(id.BotonSuma)
        val BotonResta = findViewById<Button>(id.BotonResta)

        boton.setOnClickListener {
            val edad = edadVar.text.toString().toIntOrNull()
            if (edad == null) {
                mensaje.text = "Ingresa una edad válida"
            } else if (edad >= 18) {
                mensaje.text = "Eres mayor de edad"
                Toast.makeText(this, "YYYYYAAAAAA VESSSSSSSSSSSSSSSSSS", Toast.LENGTH_SHORT).show()
            } else {
                mensaje.text = "Eres menor de edad"
                Toast.makeText(this, "NOOOOOOO ERRES MENOR", Toast.LENGTH_SHORT).show()
            }
        }

        mensaje.text = "Dale click al boton para saber si eres mayor de edad"

        BotonSuma.setOnClickListener {
            var edad = edadVar.text.toString().toIntOrNull()
            if (edad == null) mensaje.text = "ingresa una edad valida"
            else edadVar.setText((++edad).toString())
            comprobarEdad(edadVar, mensaje)
        }

        BotonResta.setOnClickListener {
            var edad = edadVar.text.toString().toIntOrNull()
            if (edad == null) mensaje.text = "ingresa una edad valida"
            else edadVar.setText((--edad).toString())
            comprobarEdad(edadVar, mensaje)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun comprobarEdad(edadVar: EditText, mensaje: TextView) {
        val edad = edadVar.text.toString().toIntOrNull()

        if (edad == null) {
            mensaje.text = "Pon tu edad primero "
        } else if (edad > 18) {
            mensaje.text = " eres mayor de edad"
        } else if (edad < 18) {
            mensaje.text = "Eres menor edad y no puedes pasar PRINGADO "
        } else {
            mensaje.text = "Tienes 18 años y eres mayor de edad"
        }

    }



}





