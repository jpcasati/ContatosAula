package com.example.teste1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.teste1.database.ContatoDatabase
import com.example.teste1.model.Contato
import kotlinx.android.synthetic.main.activity_cadastro.*

class Cadastro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menuSalvar) {

            val contato = Contato  (edtNome.text.toString(),
                                    edtEmail.text.toString(),
                                    edtFone.text.toString())

            val dao = ContatoDatabase.getInstance(this).contatoDAO()

            dao.salva(contato)

            Toast.makeText(this, "Contato Salvo!", Toast.LENGTH_LONG).show()
            finish()
        }


        return super.onOptionsItemSelected(item)
    }
}
