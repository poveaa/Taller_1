package com.example.taller_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var contador = 0
    var minimo = 0
    var maximo = 0
    var valorInicial = 0
    var minimoInicial = 0
    var maximoInicial = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val etMinimo = findViewById<EditText>(R.id.etMinimo)
        val etMaximo = findViewById<EditText>(R.id.etMaximo)
        val tvContar = findViewById<TextView>(R.id.tvContar)
        val btnRestaurar = findViewById<Button>(R.id.btnRestaurar)

        btnSumar.setOnClickListener {
            obtenerValoresMinMax(etMinimo, etMaximo)
            sumar(tvContar)
        }
        btnRestar.setOnClickListener {
            obtenerValoresMinMax(etMinimo, etMaximo)
            restar(tvContar)
        }
        
        btnRestaurar.setOnClickListener {
            restaurarValores(etMinimo, etMaximo, tvContar)
        }

        etMinimo.setText(minimoInicial.toString())
        etMaximo.setText(maximoInicial.toString())
    }

    fun restaurarValores(etMinimo: EditText, etMaximo: EditText, tvContar: TextView) {
        contador = valorInicial
        minimo = minimoInicial
        maximo = maximoInicial
        etMinimo.setText(minimo.toString())
        etMaximo.setText(maximo.toString())
        tvContar.text = contador.toString()
    }

    fun obtenerValoresMinMax(etMinimo: EditText, etMaximo: EditText) {
        minimo = etMinimo.text.toString().toInt()
        maximo = etMaximo.text.toString().toInt()
        try {
            if (minimo > maximo) {
                minimo = maximo
            } else if (maximo < minimo) {
                maximo = minimo
            }

            if (contador < minimo) {
                contador = minimo
            } else if (contador > maximo) {
                contador = maximo
            }
        } catch (e: Exception) {
            Log.e("Error Valores", "Error al obtener valores")
        }

    }

    fun actualizarContador(tvContar: TextView) {
        tvContar.text = contador.toString()
    }

    fun sumar(tvContar: TextView) {
        try {
            if (contador < maximo) {
                contador++
                tvContar.text = contador.toString()
                actualizarContador(tvContar)
            }
        } catch (e: Exception) {
            Log.e("Error Suma", "Suma Mal")
        }
    }

    fun restar(tvContar: TextView) {
        try {
            if (contador > minimo) {
                contador--
                tvContar.text = contador.toString()
                actualizarContador(tvContar)
            }
        } catch (e: Exception) {
            Log.e("Error Resta", "Resta Mal")
        }
    }
}
