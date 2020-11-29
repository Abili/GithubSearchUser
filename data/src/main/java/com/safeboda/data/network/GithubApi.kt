package com.safeboda.data.network

import com.safeboda.domain.model.Follower
import com.safeboda.domain.model.Following
import com.safeboda.domain.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("/users/{user}")
    suspend fun getUser(@Path("user") user: String): User?

    @GET("users/{user}/followers")
    suspend fun getUserFollowers(
        @Path("user") user: String,
        @Query("per_page") limit: Int,
        @Query("page") page: Int
    ): List<Follower>

    @GET("users/{user}/following")
    suspend fun getUserFollowing(
        @Path("user") user: String,
        @Query("per_page") limit: Int,
        @Query("page") page: Int
    ): List<Following>

}