package com.matteopasotti.pokemoncompose.model

data class Pokemon(
    val id: Int,
    val name: String,
    val url: String,
    val height: Int,
    val weight: Int,
    val type: String
)

/*
public class Pokemon {
    private int id;
    private String name;
    private String url;
    private int height;
    private int weight;
    private String type;
    private ArrayList<PokemonMove> moveList;
 */