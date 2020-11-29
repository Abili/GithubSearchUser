package com.safeboda.data.db

import com.safeboda.domain.model.Follower
import com.safeboda.domain.model.Following
import com.safeboda.domain.model.User

class SearchDaoImpl(private val dao: SearchDbDao) : SearchDao {
    override suspend fun getUser(user: String) = dao.getUser(user)

    override suspend fun getUserFollowers(user: String, limit: Int, start: Int) =
        dao.getUserFollowers(user, limit, start)

    override suspend fun getUserFollowing(user: String, limit: Int, start: Int) =
        dao.getUserFollowing(user, limit, start)

    override suspend fun insertUser(user: User) = dao.insertUser(user)

    override suspend fun insertUserFollowers(userName: String, followers: List<Follower>) =
        dao.insertUserFollowers(userName, followers)

    override suspend fun insertUserFollowing(userName: String, following: List<Following>) =
        dao.insertUserFollowing(userName, following)
}