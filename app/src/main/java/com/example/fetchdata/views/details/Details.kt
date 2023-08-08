package com.example.fetchdata.views.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.fetchdata.MainActivity
import com.example.fetchdata.R
import com.example.fetchdata.databinding.FragmentDetailsBinding


class Details : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsVM by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Details Fragment"

        if (arguments!= null){
            Log.v("Tag", arguments.toString())
        }

        viewModel.bundle = arguments
        viewModel.setData()

        binding.vm = viewModel
    }

}