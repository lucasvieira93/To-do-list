package com.lucasvieira.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import kotlinx.android.synthetic.main.activity_add_task.*
import java.util.*

class AdicionarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        btn_new_task.setOnClickListener {
            val tarefa_titulo = edit_text_titulo.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("titulo", tarefa_titulo)
            Toast.makeText(this, "Tarefa ${tarefa_titulo} foi adicionada!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        btn_cancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        edit_text_hora.setOnClickListener{
            val picker =
                MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .setTitleText("Qual horário?")
                    .build()

            picker.show(supportFragmentManager, "HOUR_PICKER_TAG")
        }

        edit_text_data.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Qual data?")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time) * -1
                edit_text_data?.setText(Date(it + offset).format())
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }
    }
}

