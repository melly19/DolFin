package com.example.dolfin.model

import com.example.dolfin.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)