package com.lucasvieira.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_task.*

class AdicionarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        btn_new_task.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("titulo", edit_text_titulo.text.toString())
            Toast.makeText(this, "Tarefa adicionada!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}

