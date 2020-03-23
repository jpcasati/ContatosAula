package com.example.teste1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contato(val nome: String,
                   val email: String,
                   val fone: String,
                   @PrimaryKey(autoGenerate = true)
                   val id: Int = 0) {

}