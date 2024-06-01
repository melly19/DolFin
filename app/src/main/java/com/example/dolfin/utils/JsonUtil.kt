package com.example.dolfin.utils

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

object JsonUtil {
    fun readJsonFromRaw(context: Context, rawResourceId: Int): String {
        val inputStream = context.resources.openRawResource(rawResourceId)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        bufferedReader.forEachLine { line ->
            stringBuilder.append(line)
        }
        return stringBuilder.toString()
    }
}