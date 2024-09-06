package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResultado: TextView
    private var valorAtual: String = ""
    private var operador: String = ""
    private var valorAnterior: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResultado = findViewById(R.id.textViewResultado)

        val botoesNumeros = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9
        )

        botoesNumeros.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                adicionarNumero((it as Button).text.toString())
            }
        }

        findViewById<Button>(R.id.btnSomar).setOnClickListener { definirOperador("+") }
        findViewById<Button>(R.id.btnSubtrair).setOnClickListener { definirOperador("-") }
        findViewById<Button>(R.id.btnMultiplicar).setOnClickListener { definirOperador("*") }
        findViewById<Button>(R.id.btnDividir).setOnClickListener { definirOperador("/") }

        findViewById<Button>(R.id.btnIgual).setOnClickListener { calcularResultado() }

        findViewById<Button>(R.id.btnLimpar).setOnClickListener { limpar() }
        
        findViewById<Button>(R.id.btnPonto).setOnClickListener { adicionarPonto() }
    }

    private fun adicionarNumero(numero: String) {
        valorAtual += numero
        textViewResultado.text = valorAtual
    }

    private fun adicionarPonto() {
        if (!valorAtual.contains(".")) {
            valorAtual += "."
            textViewResultado.text = valorAtual
        }
    }

    private fun definirOperador(op: String) {
        if (valorAtual.isNotEmpty()) {
            valorAnterior = valorAtual
            valorAtual = ""
            operador = op
        }
    }

    private fun calcularResultado() {
        if (valorAnterior.isNotEmpty() && valorAtual.isNotEmpty()) {
            val resultado = when (operador) {
                "+" -> valorAnterior.toDouble() + valorAtual.toDouble()
                "-" -> valorAnterior.toDouble() - valorAtual.toDouble()
                "*" -> valorAnterior.toDouble() * valorAtual.toDouble()
                "/" -> valorAnterior.toDouble() / valorAtual.toDouble()
                else -> 0.0
            }
            textViewResultado.text = resultado.toString()
            valorAtual = resultado.toString()
            valorAnterior = ""
            operador = ""
        }
    }

    private fun limpar() {
        valorAtual = ""
        valorAnterior = ""
        operador = ""
        textViewResultado.text = "0"
    }
}
