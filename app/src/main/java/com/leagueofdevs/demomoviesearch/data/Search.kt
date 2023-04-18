package com.leagueofdevs.demomoviesearch.data

import com.google.gson.annotations.SerializedName

data class Search(
    @field:SerializedName("imdbID") val imdbID: String,
    @field:SerializedName("Title") val title: String,
    @field:SerializedName("Year") val year: String,
    @field:SerializedName("Released") val released: String,
    @field:SerializedName("Genre") val genre: String,
    @field:SerializedName("Director") val director: String,
    @field:SerializedName("Plot") val plot: String,
    @field:SerializedName("Poster") val poster: String,
)
