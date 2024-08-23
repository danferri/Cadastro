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
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        val ufs = resources.getStringArray(R.array.ufs)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ufs)
        amb.spUf.adapter = adapter

        amb.btnSalvar.setOnClickListener {
            val nomeCompleto = amb.etNomeCompleto.text.toString()
            val telefone = amb.etTelefone.text.toString()
            val email = amb.etEmail.text.toString()
            val ingressarListaEmail = amb.cbEmailList.isChecked
            val sexo = when (amb.rgSexo.checkedRadioButtonId) {
                amb.rbMasculino.id -> "Masculino"
                amb.rbFeminino.id -> "Feminino"
                else -> "Não especificado"
            }
            val cidade = amb.etCidade.text.toString()
            val uf = amb.spUf.selectedItem.toString()

            val formulario = Formulario(
                nomeCompleto = nomeCompleto,
                telefone = telefone,
                email = email,
                ingressarListaEmail = ingressarListaEmail,
                sexo = sexo,
                cidade = cidade,
                uf = uf
            )
            Toast.makeText(this@MainActivity, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        amb.btnLimpar.setOnClickListener {
            amb.etNomeCompleto.text.clear()
            amb.etTelefone.text.clear()
            amb.etEmail.text.clear()
            amb.cbEmailList.isChecked = false
            amb.rgSexo.clearCheck()
            amb.etCidade.text.clear()
            amb.spUf.setSelection(0)
        }
    }
}