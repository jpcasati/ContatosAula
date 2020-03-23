package com.example.teste1.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.teste1.model.Contato

@Dao
interface ContatoDAO {

    @Insert
    fun salva(c: Contato)

    @Query("SELECT * FROM Contato")
    fun lista(): List<Contato>

    @Delete
    fun deleta(c: Contato)
}