package com.example.fetchdata.models

import java.io.Serializable

data class PostResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
): Serializable