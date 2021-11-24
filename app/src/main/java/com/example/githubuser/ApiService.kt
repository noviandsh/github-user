package com.example.githubuser

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("search/users?q={username}")
    fun search(
            @Path("username") username: String
    ): Call<SearchResponse>

    @GET("users/{username}")
    fun getUserDetail(
            @Path("username") username: String
    ): Call<DetailResponse>

    @GET("users/{username}/followers")
    fun getFollowers(
            @Path("username") username: String
    ): Call<FollowResponse>

    @GET("users/{username}/following")
    fun getFollowing(
            @Path("username") username: String
    ): Call<FollowResponse>
}