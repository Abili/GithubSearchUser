package com.safeboda.domain.model

data class UserDetail(
    val user: User,
    val followers: List<Follower>,
    val following: List<Following>
)