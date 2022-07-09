package com.example.recyclerviewbasic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class TodoViewModel : ViewModel() {
    private val _todos = MutableLiveData<ArrayList<Todo>>

    val todos : LiveData<ArrayList<Todo>>
        get() = _todos

    init {
        _todos.value = arrayListOf(
            Todo(1, "Mandi"),
            Todo(2, "Mencuci")
        )
    }
}