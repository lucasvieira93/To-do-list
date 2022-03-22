package com.lucasvieira.todolist.activity

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.lucasvieira.todolist.R
import kotlinx.android.synthetic.main.activity_main.*

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

        //ação segurando FAB TODO - setar longclick na listview
        fab_tarefa.setOnLongClickListener {
            confirmaDeletar()
            true
        }
    }

    fun confirmaDeletar() {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(this)

        //Configura título e msg
        dialog.setTitle("Clique longo!")
        dialog.setMessage("Deseja testar algo?")
        dialog.setIcon(R.drawable.ic_deletar)

        // TODO - setar ação no botão positivo
        dialog.setPositiveButton("Sim", null)
        dialog.setNegativeButton("Não", null)
        dialog.create()
        dialog.show()

    }

}
