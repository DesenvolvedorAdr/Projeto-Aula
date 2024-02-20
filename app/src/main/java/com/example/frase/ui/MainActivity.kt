package com.example.frase.ui

import com.example.frase.ui.infra.MotivationCost
import com.example.frase.ui.infra.SegurancaPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.frase.R
import com.example.frase.databinding.ActivityMainBinding
import com.example.frase.ui.data.Mock

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationCost.FILTER.ALL // Definindo um valor padrão

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val name = SegurancaPreferences(this).getString(MotivationCost.KEY.USER)
        binding.tvNomeT.text = "Olá, ${name ?: ""}"

        binding.btn1.setColorFilter(ContextCompat.getColor(this, R.color.white))

        //Event
        binding.tvTexto.setOnClickListener(){
            sortPhrase()
        }
        binding.btn1.setOnClickListener {
            binding.btn1.setColorFilter(ContextCompat.getColor(this, R.color.white))
            binding.btn2.setColorFilter(ContextCompat.getColor(this, R.color.black))
            binding.btn3.setColorFilter(ContextCompat.getColor(this, R.color.black))
            categoryId = MotivationCost.FILTER.ALL

        }

        binding.btn2.setOnClickListener {
            binding.btn2.setColorFilter(ContextCompat.getColor(this, R.color.white))
            binding.btn1.setColorFilter(ContextCompat.getColor(this, R.color.black))
            binding.btn3.setColorFilter(ContextCompat.getColor(this, R.color.black))
            categoryId = MotivationCost.FILTER.HAPPY

        }

        binding.btn3.setOnClickListener {
            binding.btn3.setColorFilter(ContextCompat.getColor(this, R.color.white))
            binding.btn1.setColorFilter(ContextCompat.getColor(this, R.color.black))
            binding.btn2.setColorFilter(ContextCompat.getColor(this, R.color.black))
            categoryId = MotivationCost.FILTER.SUNNY

        }


    }

    private fun sortPhrase() {
        val phrase = Mock().getPhrase(categoryId)
        binding.tvTexto.text = phrase
    }
}