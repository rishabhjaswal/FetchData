package com.example.fetchdata.views.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.fetchdata.MainActivity
import com.example.fetchdata.R
import com.example.fetchdata.databinding.FragmentHomeBinding
import com.example.fetchdata.databinding.FragmentSecondBinding
import com.example.fetchdata.views.home.HomeVM


class Second : Fragment() {

    lateinit var binding: FragmentSecondBinding
    private val viewModel: SecondVM by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.navController = Navigation.findNavController(view)

        binding.vm = viewModel

        (activity as MainActivity).supportActionBar?.title = "List Fragment"
    }

}