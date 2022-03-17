package com.lucasvieira.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pegar dados da tela anterior - TODO(reason = "A lista só retorna o ultimo valor repetidamente")

        var bundle: Bundle? = intent.extras
        if (bundle != null) {
            var message = intent.getStringExtra("titulo").toString()
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
        //lista Array para mostrar
        val dados = arrayOf("Lucas", "Matheus", "Junior")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dados)
        listview_tarefas.adapter = adapter

        //ação botão FAB
        fab_tarefa.setOnClickListener {
            val intent = Intent(this, AdicionarActivity::class.java)
            startActivity(intent)
        }
    }

}
