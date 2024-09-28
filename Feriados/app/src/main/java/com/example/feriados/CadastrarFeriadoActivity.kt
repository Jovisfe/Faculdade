package com.example.feriados

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.util.*

class CadastrarFeriadoActivity : AppCompatActivity() {

    private lateinit var nomeFeriado: EditText
    private lateinit var estadoFeriado: EditText
    private lateinit var municipioFeriado: EditText
    private lateinit var dataFeriado: EditText
    private lateinit var tipoFeriado: RadioGroup
    private lateinit var btnSalvar: Button
    private var dataSelecionada: LocalDate? = null
    private var position: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_feriado)

        nomeFeriado = findViewById(R.id.nomeFeriado)
        estadoFeriado = findViewById(R.id.estadoFeriado)
        municipioFeriado = findViewById(R.id.municipioFeriado)
        dataFeriado = findViewById(R.id.dataFeriado)
        tipoFeriado = findViewById(R.id.tipoFeriado)
        btnSalvar = findViewById(R.id.btnSalvar)

        position = intent.getIntExtra("position", -1)
        if (position != -1) {
            val feriado = MainActivity.feriadosList[position!!]
            preencherCampos(feriado)
        }

        dataFeriado.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, ano, mes, dia ->
                dataSelecionada = LocalDate.of(ano, mes + 1, dia)
                dataFeriado.setText(dataSelecionada.toString())
            }, year, month, day)
            datePicker.show()
        }

        btnSalvar.setOnClickListener {
            salvarFeriado()
        }
    }

    private fun preencherCampos(feriado: Feriado) {
        nomeFeriado.setText(feriado.nome)
        dataSelecionada = feriado.data
        dataFeriado.setText(feriado.data.toString())

        when (feriado.tipo) {
            "Nacional" -> tipoFeriado.check(R.id.radioNacional)
            "Estadual" -> {
                tipoFeriado.check(R.id.radioEstadual)
                estadoFeriado.setText(feriado.estado)
            }
            "Municipal" -> {
                tipoFeriado.check(R.id.radioMunicipal)
                estadoFeriado.setText(feriado.estado)
                municipioFeriado.setText(feriado.municipio)
            }
        }
    }

    private fun salvarFeriado() {
        val nome = nomeFeriado.text.toString()
        val estado = estadoFeriado.text.toString()
        val municipio = municipioFeriado.text.toString()
        val tipoId = tipoFeriado.checkedRadioButtonId
        val tipoSelecionado = findViewById<RadioButton>(tipoId).text.toString()

        if (nome.isEmpty() || dataSelecionada == null) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return
        }

        if (dataSelecionada!!.isBefore(LocalDate.now())) {
            Toast.makeText(this, "Data inválida. Selecione uma data futura.", Toast.LENGTH_SHORT).show()
            return
        }

        val novoFeriado = Feriado(
            nome = nome,
            data = dataSelecionada!!,
            tipo = tipoSelecionado,
            estado = if (tipoSelecionado == "Estadual" || tipoSelecionado == "Municipal") estado else null,
            municipio = if (tipoSelecionado == "Municipal") municipio else null
        )

        if (position != -1) {
            MainActivity.feriadosList[position!!] = novoFeriado
        } else {
            MainActivity.feriadosList.add(novoFeriado)
        }

        Toast.makeText(this, "Feriado salvo com sucesso!", Toast.LENGTH_SHORT).show()
        finish()
    }
}
