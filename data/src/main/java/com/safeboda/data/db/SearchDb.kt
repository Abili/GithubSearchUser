package com.safeboda.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.safeboda.domain.model.*


@Database(
    entities = [User::class, Follower::class, Following::class],
    version = 1,
    exportSchema = false
)
abstract class SearchDb : RoomDatabase() {
    abstract fun searchDao(): SearchDbDao
}