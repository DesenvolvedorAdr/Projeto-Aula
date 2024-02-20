package com.example.frase.ui

import com.example.frase.ui.infra.SegurancaPreferences
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.frase.databinding.ActivityLoginBinding
import com.example.frase.ui.infra.MotivationCost

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        verySave()

        binding.btnEntrar.setOnClickListener {
            dadosSave()
        }
    }

    private fun dadosSave() {
        val name = binding.etNome.text.toString()

        if (name.isNotEmpty()) {
            SegurancaPreferences(this).storeString("USER", name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Informe o nome!", Toast.LENGTH_LONG).show()
        }
    }

    private fun verySave() {
        val name = SegurancaPreferences(this).getString(MotivationCost.KEY.USER)
        if (!name.isNullOrEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}