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

        var dados = arrayOf("Lucas", "Matheus", "Junior", "Vinicius", "Tamires")

        //Pegar dados da tela anterior
        var bundle: Bundle? = intent.extras
        if (bundle != null) {
            val message = intent.getStringExtra("titulo").toString()
            dados += message
        }

        //lista Array para mostrar
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dados)
        listview_tarefas.adapter = adapter

        //ação botão FAB
        fab_tarefa.setOnClickListener {
            val intent = Intent(this, AdicionarActivity::class.java)
            startActivity(intent)
        }
    }


}
