package com.example.fetchdata.networkcalls

import com.example.fetchdata.models.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApi {

    @GET(POSTS)
    suspend fun getPosts(): Response<PostResponse>
}