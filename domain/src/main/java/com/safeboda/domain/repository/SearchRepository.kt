package com.safeboda.domain.repository

import com.safeboda.domain.model.Follower
import com.safeboda.domain.model.Following
import com.safeboda.domain.model.User

interface SearchRepository {

    suspend fun getUser(userName: String): User?

    suspend fun getUserFollowers(userName: String): List<Follower>

    suspend fun getUserFollowing(userName: String): List<Following>
}