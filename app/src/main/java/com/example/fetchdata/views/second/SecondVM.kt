package com.example.fetchdata.views.second

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fetchdata.MainActivity
import com.example.fetchdata.R
import com.example.fetchdata.adapters.PostAdapter
import com.example.fetchdata.models.PostResponse
import com.example.fetchdata.models.PostResponseItem
import com.example.fetchdata.networkcalls.ApiEnums
import com.example.fetchdata.networkcalls.ApiProcessor
import com.example.fetchdata.networkcalls.Repository
import com.example.fetchdata.networkcalls.RetrofitApi
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondVM : ViewModel() {

    val ctx by lazy { MainActivity.context.get() }

    var postList =  ArrayList<PostResponseItem>()

    var postAdapter = PostAdapter()

    var navController: NavController? = null


    private var postAdapterClick = object : PostAdapter.onPlaceClick{
        override fun onClick(position: Int) {
            val bundle = Bundle()
            bundle.putSerializable("selected", postList[position])

            navController?.navigate(R.id.action_second_to_details, bundle)
        }
    }

    init {
        getPosts()
        postAdapter.setClickListener(postAdapterClick)
    }


    private fun getPosts() = viewModelScope.launch {
        Repository.makeCall(
            apiKey = ApiEnums.POSTS,
            loader = true,
            saveInCache = false,
            requestProcessor = object : ApiProcessor<Response<PostResponse>> {
                override suspend fun sendRequest(retrofitApi: RetrofitApi): Response<PostResponse> {
                    return retrofitApi.getPosts()
                }

                override fun onResponse(res: Response<PostResponse>) {
                    if (res.isSuccessful) {

                        postList.addAll(res.body()!!)

                        postAdapter.updateList(postList)

                    }
                }
            }
        )
    }
}



