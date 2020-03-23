package com.example.teste1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teste1.dao.ContatoDAO
import com.example.teste1.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class ContatoDatabase: RoomDatabase() {

    abstract fun contatoDAO(): ContatoDAO

    companion object {

        private var database: ContatoDatabase? = null
        private val DATABASE = "ContatoDB"

        fun getInstance(context: Context): ContatoDatabase {
            return database ?: criaBanco(context).also {database = it}
        }

        private fun criaBanco(context: Context): ContatoDatabase {
            return Room.databaseBuilder(context,
                    ContatoDatabase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}