package com.example.feriados

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.time.format.DateTimeFormatter

class VisualizarFeriadosActivity : AppCompatActivity() {

    private lateinit var listViewFeriados: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_feriados)

        listViewFeriados = findViewById(R.id.listViewFeriados)
        atualizarLista()

        listViewFeriados.setOnItemClickListener { _, _, position, _ ->
            val feriadoSelecionado = MainActivity.feriadosList[position]
            mostrarOpcoes(feriadoSelecionado, position)
        }
    }

    private fun atualizarLista() {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val feriadosInfo = MainActivity.feriadosList.map { feriado ->
            "${feriado.nome} - ${feriado.data.format(formatter)} - ${feriado.tipo}" +
                    (if (feriado.estado != null) " - ${feriado.estado}" else "") +
                    (if (feriado.municipio != null) " - ${feriado.municipio}" else "")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, feriadosInfo)
        listViewFeriados.adapter = adapter
    }

    private fun mostrarOpcoes(feriado: Feriado, position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(feriado.nome)
        builder.setItems(arrayOf("Editar", "Excluir")) { _, which ->
            when (which) {
                0 -> editarFeriado(feriado, position)
                1 -> excluirFeriado(position)
            }
        }
        builder.show()
    }

    private fun editarFeriado(feriado: Feriado, position: Int) {
        val intent = Intent(this, CadastrarFeriadoActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    private fun excluirFeriado(position: Int) {
        MainActivity.feriadosList.removeAt(position)
        atualizarLista()
    }
}