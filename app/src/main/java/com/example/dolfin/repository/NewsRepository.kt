package com.example.dolfin.repository

import com.example.dolfin.api.RetrofitInstance
import com.example.dolfin.db.ArticleDatabase
import com.example.dolfin.model.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(query: String, from: String, sortBy: String, language: String, domains: String) =
        RetrofitInstance.api.getHeadLines(query, from, sortBy, language, domains)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}