package com.example.dolfin.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.dolfin.R
import com.example.dolfin.model.NewsResponse
import com.example.dolfin.utils.JsonUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    val newsLiveData: MutableLiveData<NewsResponse> = MutableLiveData()

    fun loadNewsFromJson() {
        val json = JsonUtil.readJsonFromRaw(getApplication(), R.raw.news)
        val type = object : TypeToken<NewsResponse>() {}.type
        val newsResponse: NewsResponse = Gson().fromJson(json, type)
        newsLiveData.postValue(newsResponse)
    }
}
