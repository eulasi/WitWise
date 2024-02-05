package com.example.navbaranalysisone.data.remote

// Singleton that can be used to access the API
object ApiDetails {
    // Base URLs and endpoints for APIs
    const val BASE_URL_API1 = "https://poetrydb.org/"
    const val END_POINT_API1 = "title,random/;1"

    const val BASE_URL_API2 = "https://v2.jokeapi.dev/"
    const val END_POINT_API2 = "joke/Any"

    const val BASE_URL_API3 = "https://api.quotable.io/"
    const val END_POINT_API3 = "random"

}

// APIs
// PoetryDB - https://github.com/thundercomb/poetrydb#readme
// https://poetrydb.org/title,random/;1

// JokeAPI - https://v2.jokeapi.dev/
// https://v2.jokeapi.dev/joke/Any

// QuoteAPI - https://github.com/lukePeavey/quotable
// https://api.quotable.io/random

/* Alternative Backup */
// Advice Slip - https://api.adviceslip.com/
// https://api.adviceslip.com/advice


