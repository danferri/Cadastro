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
        amb.ufSp.adapter = adapter

        amb.saveBt.setOnClickListener {
            val nomeCompleto = amb.nameEt.text.toString()
            val telefone = amb.phoneEt.text.toString()
            val email = amb.emailEt.text.toString()
            val ingressarListaEmail = amb.emaillistCb.isChecked
            val sexo = when (amb.genderRg.checkedRadioButtonId) {
                amb.maleRb.id -> "Masculino"
                amb.femaleRb.id -> "Feminino"
                else -> "Não especificado"
            }
            val cidade = amb.cityEt.text.toString()
            val uf = amb.ufSp.selectedItem.toString()

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

        amb.limparBt.setOnClickListener {
            amb.nameEt.text.clear()
            amb.phoneEt.text.clear()
            amb.emailEt.text.clear()
            amb.emaillistCb.isChecked = false
            amb.genderRg.clearCheck()
            amb.cityEt.text.clear()
            amb.ufSpdan .setSelection(0)
        }
    }
}