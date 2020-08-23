package com.example.androidxdemo.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.androidxdemo.R
import com.example.androidxdemo.base.SingletonHolder

class SharedPreferencesUtils2 private constructor() {

    private var share: SharedPreferences? = null

    constructor(context: Context) : this() {
        val shpName = context.applicationContext.resources.getString(R.string.shp_name)
        share = context.applicationContext.getSharedPreferences(shpName, Context.MODE_PRIVATE)
    }

    companion object : SingletonHolder<SharedPreferencesUtils2, Context>(::SharedPreferencesUtils2)

    fun getString(key: String?): String? {
        return share!!.getString(key, null)
    }

    fun getInt(key: String?): Int {
        return share!!.getInt(key, 0)
    }

    fun getLong(key: String?): Long {
        return share!!.getLong(key, 0)
    }

    fun getFloat(key: String?): Float {
        return share!!.getFloat(key, 0f)
    }

    fun getBoolean(key: String?): Boolean {
        return share!!.getBoolean(key, false)
    }

    operator fun contains(key: String?): Boolean {
        return share!!.contains(key)
    }

    fun putString(key: String?, value: String?) {
        share!!.edit().putString(key, value).apply()
    }

    fun putInt(key: String?, value: Int) {
        share!!.edit().putInt(key, value).apply()
    }

    fun putLong(key: String?, value: Long) {
        share!!.edit().putLong(key, value).apply()
    }

    fun putFloat(key: String?, value: Float) {
        share!!.edit().putFloat(key, value).apply()
    }

    fun putBoolean(key: String?, value: Boolean) {
        share!!.edit().putBoolean(key, value).apply()
    }

    fun remove(key: String?) {
        share!!.edit().remove(key).apply()
    }

    fun clear() {
        share!!.edit().clear().apply()
    }
}