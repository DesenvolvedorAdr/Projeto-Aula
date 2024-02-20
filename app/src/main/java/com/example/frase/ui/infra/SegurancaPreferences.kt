package com.example.frase.ui.infra

import android.content.Context
import android.content.SharedPreferences

class SegurancaPreferences(context: Context) {

    private val seguranca: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)


    fun storeString(key: String, str: String) {

        seguranca.edit().putString(key, str).apply()

    }
    fun getString(key: String): String {

        return seguranca.getString(key, "") ?: ""

    }
}