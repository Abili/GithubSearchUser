package com.safeboda.data.db

import com.safeboda.domain.model.Follower
import com.safeboda.domain.model.Following
import com.safeboda.domain.model.User

interface SearchDao {

    suspend fun getUser(user: String): User?

    suspend fun getUserFollowers(user: String, limit: Int, start: Int): List<Follower>

    suspend fun getUserFollowing(user: String, limit: Int, start: Int): List<Following>

    suspend fun insertUser(user: User)

    suspend  fun insertUserFollowers(userName: String, followers: List<Follower>)

    suspend fun insertUserFollowing(userName: String, following: List<Following>)

}