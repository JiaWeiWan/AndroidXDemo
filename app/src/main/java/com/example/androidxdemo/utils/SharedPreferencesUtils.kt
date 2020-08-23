package com.example.androidxdemo.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesUtils private constructor() {
    private lateinit var share: SharedPreferences

    constructor(context: Context) : this() {
        share = context.applicationContext.getSharedPreferences(SHARE_DEFAULT, Context.MODE_PRIVATE)
    }

    companion object {
        private const val SHARE_DEFAULT = "SHARE_DEFAULT"
        private var instance: SharedPreferencesUtils? = null

        fun getInstance(context: Context): SharedPreferencesUtils {
            val i =
                instance
            if (i != null) return i
            return synchronized(this) {
                val i2 =
                    instance
                if (i2 != null) i2
                else {
                    val created =
                        SharedPreferencesUtils(
                            context.applicationContext
                        )
                    instance = created
                    created
                }

            }
        }

    }

    fun getString(key: String): String? = share.getString(key, "")

    fun getInt(key: String): Int = share.getInt(key, 0)

    fun getLong(key: String): Long = share.getLong(key, 0)

    fun getFloat(key: String): Float = share.getFloat(key, 0f)

    fun getBoolean(key: String): Boolean = share.getBoolean(key, false)

    fun contains(key: String): Boolean = share.contains(key)

    fun putString(key: String, value: String?) = value?.let { share.edit().putString(key, value).apply() }

    fun putInt(key: String, value: Int?) = value?.let { share.edit().putInt(key, it).apply() }

    fun putLong(key: String, value: Long?) = value?.let { share.edit().putLong(key, it).apply() }

    fun putFloat(key: String, value: Float?) = value?.let { share.edit().putFloat(key, it).apply() }

    fun putBoolean(key: String, value: Boolean?) = value?.let { share.edit().putBoolean(key, it).apply() }

    fun remove(key: String) = share.edit().remove(key).apply()

    fun clear() = share.edit().clear().apply()
}