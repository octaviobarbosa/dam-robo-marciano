package com.example.dam_robo_marciano

import MarcianoPremium
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RespostaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)

        val pergunta = intent.getStringExtra("pergunta")
        val oper1 = intent.getDoubleExtra("oper1", 0.0)
        val oper2 = intent.getDoubleExtra("oper2", 0.0)

        val marciano = MarcianoPremium {
            "Ação personalizada"
        }
        var resposta: String? = null

        if(oper1 > 0 && oper2 > 0) {
            resposta = marciano.responda(pergunta.toString(), oper1, oper2)
        } else {
            resposta = marciano.responda(pergunta.toString())
        }

        val txtResposta = findViewById<TextView>(R.id.txtResposta)
        txtResposta.text = resposta


        val voltar = findViewById<Button>(R.id.btnVoltar)
        voltar.setOnClickListener {
            backToMain()
        }

    }

    fun backToMain() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("clear", true)
        }
        startActivity(intent)
    }

    override fun onBackPressed() {
        backToMain()
    }
}