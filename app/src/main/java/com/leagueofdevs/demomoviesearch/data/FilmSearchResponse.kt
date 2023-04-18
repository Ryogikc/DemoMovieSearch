package com.leagueofdevs.demomoviesearch.data

import com.google.gson.annotations.SerializedName

data class FilmSearchResponse(
    @field:SerializedName("Search")val films: List<Search>,
    @field:SerializedName("totalResults")val totalResults: Int,
    @field:SerializedName("Response")val response: String
)
