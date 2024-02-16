package com.example.todo_app.viewmodel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com"

interface TodosApi {
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    companion object {
        var todosService: TodosApi? = null

        fun getInstance(): TodosApi {
            if (todosService === null) {
                todosService = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(TodosApi::class.java)
            }
            return todosService!!
        }
    }
}