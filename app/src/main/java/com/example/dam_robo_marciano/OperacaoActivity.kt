package com.example.dam_robo_marciano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class OperacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacao)

        val pergunta = intent.getStringExtra("pergunta")
        val operacao = findViewById<TextView>(R.id.txtOperacao)
        operacao.text = pergunta.toString().capitalize()

        val continuar = findViewById<Button>(R.id.btnContinuar)
        continuar.setOnClickListener {
            val valor1 = findViewById<EditText>(R.id.edtValor1)
            val valor2 = findViewById<EditText>(R.id.edtValor2)

            val oper1 = valor1.text.toString().toDouble()
            val oper2 = valor2.text.toString().toDouble()

            val intent = Intent(this, RespostaActivity::class.java).apply {
                putExtra("pergunta", pergunta)
                putExtra("oper1", oper1)
                putExtra("oper2", oper2)
            }
            startActivity(intent)
        }
    }
}