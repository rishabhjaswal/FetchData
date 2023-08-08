package com.example.fetchdata.views.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.fetchdata.MainActivity
import com.example.fetchdata.R
import com.example.fetchdata.databinding.FragmentHomeBinding


class Home : Fragment() {

    lateinit var binding:FragmentHomeBinding
    private val viewModel: HomeVM by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel

        (activity as MainActivity).supportActionBar?.title = "Home Fragment"
    }

}