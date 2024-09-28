package com.example.feriados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val feriadosList = ArrayList<Feriado>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnVisualizar = findViewById<Button>(R.id.btnVisualizar)

        btnCadastrar.setOnClickListener {
            val intent = Intent(this, CadastrarFeriadoActivity::class.java)
            startActivity(intent)
        }

        btnVisualizar.setOnClickListener {
            val intent = Intent(this, VisualizarFeriadosActivity::class.java)
            startActivity(intent)
        }
    }
}
