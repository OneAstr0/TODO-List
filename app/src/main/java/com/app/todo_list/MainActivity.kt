package com.app.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val userData: EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.button)

        // Создаю пустой список
        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter

        // Удаление элементов при нажатии на них
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text = listView.getItemAtPosition(i).toString()
            adapter.remove(text)
            Toast.makeText(this, "Удалена заметка: $text", Toast.LENGTH_SHORT).show()
        }

        // Добавление элемента в список
        button.setOnClickListener {
            val text = userData.text.toString().trim()
            if (text != "" && text.length > 1)
                adapter.insert(text, 0)
        }
    }
}