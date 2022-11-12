package com.example.pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.adapter.PokemonAdapter
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.domain.Pokemon
import com.example.pokedex.domain.PokemonType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var pokemonList = mutableListOf<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        initializeListPokemon()
        setupRecycler(binding.recycler, pokemonList)

        setContentView(view)
    }

    private fun setupRecycler(recyclerView: RecyclerView, listPokemon: MutableList<Pokemon>) {

        //RecyclerView
        //Ordenando alfabeticamente
        recyclerView.adapter = PokemonAdapter(listPokemon)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun initializeListPokemon() {
        pokemonList = mutableListOf(
            Pokemon(
                imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/094.png",
                number = 1,
                name = "Bulbasaur",
                types = listOf(PokemonType(name = "Plant"), PokemonType("Green"))
            ), Pokemon(
                imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/094.png",
                number = 2,
                name = "Yvisaur",
                types = listOf(PokemonType(name = "Plant"), PokemonType("Green"))
            ), Pokemon(
                imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/094.png",
                number = 3,
                name = "Bulbasaur",
                types = listOf(PokemonType(name = "Plant"), PokemonType("Green"))
            ), Pokemon(
                imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/094.png",
                number = 4,
                name = "Yvisaur",
                types = listOf(PokemonType(name = "Plant"), PokemonType("Green"))
            )
        )
    }


}