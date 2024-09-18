package com.example.formulario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNome = findViewById<EditText>(R.id.et_nome)
        val etDataNascimento = findViewById<EditText>(R.id.et_data_nascimento)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etTelefone = findViewById<EditText>(R.id.et_telefone)

        val rgSatisfacao = findViewById<RadioGroup>(R.id.rg_satisfacao)
        val rgIndicaria = findViewById<RadioGroup>(R.id.rg_indicaria)
        val rgUtilidade = findViewById<RadioGroup>(R.id.rg_utilidade)

        val cbRobustez = findViewById<CheckBox>(R.id.cb_robustez)
        val cbAgilidade = findViewById<CheckBox>(R.id.cb_agilidade)
        val cbInovacao = findViewById<CheckBox>(R.id.cb_inovacao)
        val cbLentidao = findViewById<CheckBox>(R.id.cb_lentidao)
        val cbIneficiencia = findViewById<CheckBox>(R.id.cb_ineficiencia)
        val cbProdutividade = findViewById<CheckBox>(R.id.cb_produtividade)
        val cbBurocracia = findViewById<CheckBox>(R.id.cb_burocracia)

        val btnEnviar = findViewById<Button>(R.id.btn_enviar)

        btnEnviar.setOnClickListener {
            val nome = etNome.text.toString()
            val dataNascimento = etDataNascimento.text.toString()
            val email = etEmail.text.toString()
            val telefone = etTelefone.text.toString()

            val satisfacao = findViewById<RadioButton>(rgSatisfacao.checkedRadioButtonId)?.text
            val indicaria = findViewById<RadioButton>(rgIndicaria.checkedRadioButtonId)?.text
            val utilidade = findViewById<RadioButton>(rgUtilidade.checkedRadioButtonId)?.text

            val destaques = mutableListOf<String>()
            if (cbRobustez.isChecked) destaques.add("Robustez")
            if (cbAgilidade.isChecked) destaques.add("Agilidade")
            if (cbInovacao.isChecked) destaques.add("Inovação")
            if (cbLentidao.isChecked) destaques.add("Lentidão")
            if (cbIneficiencia.isChecked) destaques.add("Ineficiência")
            if (cbProdutividade.isChecked) destaques.add("Produtividade")
            if (cbBurocracia.isChecked) destaques.add("Burocracia")

            val destaquesStr = destaques.joinToString(", ")

            val resumo = """
                Nome: $nome
                Data de Nascimento: $dataNascimento
                Email: $email
                Telefone: $telefone
                
                Satisfação: $satisfacao
                Indicaria: $indicaria
                Utilidade: $utilidade
                
                Pontos de Destaque: $destaquesStr
            """.trimIndent()

            AlertDialog.Builder(this)
                .setTitle("Confirmação")
                .setMessage(resumo)
                .setPositiveButton("Confirmar") { _, _ ->
                    Toast.makeText(this, "Pesquisa enviada com sucesso!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Voltar", null)
                .show()
        }
    }
}
