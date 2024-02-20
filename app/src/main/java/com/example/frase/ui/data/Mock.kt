package com.example.frase.ui.data

import com.example.frase.ui.infra.MotivationCost
import kotlin.random.Random

data class Phrase(val description: String, val categoryID: Int)

class Mock {

    private val all = MotivationCost.FILTER.ALL
    private val happy = MotivationCost.FILTER.HAPPY
    private val sunny = MotivationCost.FILTER.SUNNY

    private val mListPhrase = listOf<Phrase>(
        Phrase("oi", sunny),
        Phrase("ola", happy),
        Phrase("hi", sunny)
    )

    fun getPhrase(value: Int): String {
        val filtered = mListPhrase.filter { it.categoryID == value || value == all }
        if (filtered.isEmpty()) {
            throw IllegalArgumentException("No phrases available for the given category ID: $value")
        }
        return filtered[Random.nextInt(filtered.size)].description
    }
}