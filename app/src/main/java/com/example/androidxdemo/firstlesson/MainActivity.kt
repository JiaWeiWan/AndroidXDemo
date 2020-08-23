package com.example.androidxdemo.firstlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.example.androidxdemo.R
import com.example.androidxdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        myViewModel = ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(
            MyViewModel::class.java)
        binding.data = myViewModel
        binding.lifecycleOwner = this

    }

    override fun onPause() {
        super.onPause()
        myViewModel.save()
    }
}