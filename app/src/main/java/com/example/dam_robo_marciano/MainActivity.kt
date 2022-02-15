package com.example.dam_robo_marciano

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clear = intent.getBooleanExtra("clear", false)
        if(clear) {
            val editText = findViewById<EditText>(R.id.edtPergunta)
            editText.text.clear()
            editText.requestFocus()
        }

        val enviar = findViewById<Button>(R.id.btnEnviar)

        enviar.setOnClickListener {
            enviarPergunta()
        }
    }

    private fun enviarPergunta() {
        val editText = findViewById<EditText>(R.id.edtPergunta)
        val pergunta = editText.text.toString()

        val lower = pergunta.lowercase()

        if(lower == "some" || lower == "subtraia" || lower == "multiplique" || lower == "divida") {
            val intent = Intent(this, OperacaoActivity::class.java).apply {
                putExtra("pergunta", pergunta)
            }
            startActivity(intent)
        } else {
            val intent = Intent(this, RespostaActivity::class.java).apply {
                putExtra("pergunta", pergunta)
            }
            startActivity(intent)
        }


    }
}
