package com.example.datas

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataSelecionada1: Calendar
    private lateinit var dataSelecionada2: Calendar
    private lateinit var dataSelecionada3: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextData1 = findViewById<EditText>(R.id.editTextData1)
        val editTextData2 = findViewById<EditText>(R.id.editTextData2)
        val editTextData3 = findViewById<EditText>(R.id.editTextData3)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val textoResultado = findViewById<TextView>(R.id.textoResultado)

        val dataMinima = Calendar.getInstance()
        dataMinima.set(1900, Calendar.JANUARY, 1)

        val dataMaxima = Calendar.getInstance()
        dataMaxima.set(2029, Calendar.DECEMBER, 31)

        fun abrirDatePicker(editText: EditText, calendario: Calendar) {
            val dateSetListener = DatePickerDialog.OnDateSetListener { _, ano, mes, dia ->
                calendario.set(Calendar.YEAR, ano)
                calendario.set(Calendar.MONTH, mes)
                calendario.set(Calendar.DAY_OF_MONTH, dia)

                val formatoData = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                editText.setText(formatoData.format(calendario.time))
            }

            val datePickerDialog = DatePickerDialog(
                this, dateSetListener,
                calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.datePicker.minDate = dataMinima.timeInMillis
            datePickerDialog.datePicker.maxDate = dataMaxima.timeInMillis

            datePickerDialog.show()
        }

        dataSelecionada1 = Calendar.getInstance()
        dataSelecionada2 = Calendar.getInstance()
        dataSelecionada3 = Calendar.getInstance()

        editTextData1.setOnClickListener {
            abrirDatePicker(editTextData1, dataSelecionada1)
        }

        editTextData2.setOnClickListener {
            abrirDatePicker(editTextData2, dataSelecionada2)
        }

        editTextData3.setOnClickListener {
            abrirDatePicker(editTextData3, dataSelecionada3)
        }

        btnEnviar.setOnClickListener {
            if (editTextData1.text.isNotEmpty() && editTextData2.text.isNotEmpty() && editTextData3.text.isNotEmpty()) {
                val datasOrdenadas = listOf(dataSelecionada1.time, dataSelecionada2.time, dataSelecionada3.time).sortedDescending()

                val diferenca1Para2 = calcularDiferencaDatas(datasOrdenadas[1], datasOrdenadas[2])
                val diferenca2Para3 = calcularDiferencaDatas(datasOrdenadas[0], datasOrdenadas[1])

                val formatoData = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val resultadoTexto = """
                    Datas ordenadas: 
                    1) ${formatoData.format(datasOrdenadas[0])}
                    2) ${formatoData.format(datasOrdenadas[1])}
                    3) ${formatoData.format(datasOrdenadas[2])}
                    
                    Diferença entre as datas:
                    - Menor para a segunda menor: $diferenca1Para2 dias
                    - Segunda menor para a maior: $diferenca2Para3 dias
                """.trimIndent()

                textoResultado.text = resultadoTexto
            } else {
                textoResultado.text = "Por favor, escolha todas as datas."
            }
        }
    }

    private fun calcularDiferencaDatas(data1: Date, data2: Date): Long {
        val diferencaMillis = data1.time - data2.time
        return diferencaMillis / (1000 * 60 * 60 * 24)
    }
}