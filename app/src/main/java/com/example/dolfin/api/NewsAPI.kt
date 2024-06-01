package com.example.dolfin.api

import com.example.dolfin.model.NewsResponse
import com.example.dolfin.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    //All popular headlines
    @GET("v2/everything")
    suspend fun getHeadLines(
        @Query("q")
        query: String = "scam",
        @Query("from")
        from: String = "2024-05-03",
        @Query("sortBy")
        sortBy: String = "popularity",
        @Query("apiKey")
        apiKey: String = API_KEY,
        @Query("language")
        language: String = "en",
        @Query("domains")
        domains: String = "straitstimes.com,channelnewsasia.com"
    ): Response<NewsResponse>

    //For searching
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

}