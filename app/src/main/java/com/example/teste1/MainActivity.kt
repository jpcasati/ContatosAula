package com.example.teste1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.teste1.database.ContatoDatabase
import com.example.teste1.model.Contato
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            startActivity(Intent(this, Cadastro::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        carregaLista()

    }

    private fun carregaLista() {

        val dao = ContatoDatabase.getInstance(this).contatoDAO()

        val lista: List<Contato> = dao.lista()

        val adapter = ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, lista)
        lstContato.adapter = adapter
    }
}