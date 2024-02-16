package com.example.todo_app.viewmodel


data class Success(val todos: List<Todo>)

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean,
)