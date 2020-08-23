package com.example.androidxdemo.firstlesson

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import com.example.androidxdemo.R
import com.example.androidxdemo.utils.SharedPreferencesUtils

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var handle: SavedStateHandle
    private val key = getApplication<Application>().resources.getString(R.string.data_key)

    constructor(application: Application, handle: SavedStateHandle) : this(application) {
        this.handle = handle
        if (!handle.contains(key)) load()
    }

    fun getNumber(): LiveData<Int> {
        return handle.getLiveData<Int>(key)
    }

    private fun load() {
        val shp = SharedPreferencesUtils.getInstance(getApplication())
        val number = shp.getInt(key)
        handle.set(key, number)
    }

    fun save() {
        val shp = SharedPreferencesUtils.getInstance(getApplication())
        val number: Int? = getNumber().value
        shp.putInt(key, number)
    }

    fun add(x: Int) {
        handle.set(key, getNumber().value as Int + x)
    }
}