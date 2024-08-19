package com.example.cadastro

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etNomeCompleto: EditText
    private lateinit var etTelefone: EditText
    private lateinit var etEmail: EditText
    private lateinit var cbEmailList: CheckBox
    private lateinit var rgSexo: RadioGroup
    private lateinit var etCidade: EditText
    private lateinit var spUf: Spinner
    private lateinit var btnLimpar: Button
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar as views
        etNomeCompleto = findViewById(R.id.etNomeCompleto)
        etTelefone = findViewById(R.id.etTelefone)
        etEmail = findViewById(R.id.etEmail)
        cbEmailList = findViewById(R.id.cbEmailList)
        rgSexo = findViewById(R.id.rgSexo)
        etCidade = findViewById(R.id.etCidade)
        spUf = findViewById(R.id.spUf)
        btnLimpar = findViewById(R.id.btnLimpar)
        btnSalvar = findViewById(R.id.btnSalvar)

        // Configurar o Spinner de UF
        val ufs = resources.getStringArray(R.array.ufs)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ufs)
        spUf.adapter = adapter

        // Lógica do botão Salvar
        btnSalvar.setOnClickListener {
            val nomeCompleto = etNomeCompleto.text.toString()
            val telefone = etTelefone.text.toString()
            val email = etEmail.text.toString()
            val ingressarListaEmail = cbEmailList.isChecked
            val sexo = when (rgSexo.checkedRadioButtonId) {
                R.id.rbMasculino -> "Masculino"
                R.id.rbFeminino -> "Feminino"
                else -> "Não especificado"
            }
            val cidade = etCidade.text.toString()
            val uf = spUf.selectedItem.toString()

            val formulario = Formulario(nomeCompleto, telefone, email, ingressarListaEmail, sexo, cidade, uf)
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        // Lógica do botão Limpar
        btnLimpar.setOnClickListener {
            etNomeCompleto.text.clear()
            etTelefone.text.clear()
            etEmail.text.clear()
            cbEmailList.isChecked = false
            rgSexo.clearCheck()
            etCidade.text.clear()
            spUf.setSelection(0)
        }
    }
}