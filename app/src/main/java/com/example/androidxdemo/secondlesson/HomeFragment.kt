package com.example.androidxdemo.secondlesson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidxdemo.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button3.setOnClickListener {
            if (et_name.text.isNullOrBlank()) {
                return@setOnClickListener
            }
            val bundle = Bundle()
            bundle.putString("my_name", et_name.text.toString())
            val nav = Navigation.findNavController(it)
            nav.navigate(R.id.action_homeFragment2_to_detailFragment, bundle)
        }
    }

}