package com.safeboda.githubuser.di

import androidx.room.Room
import com.safeboda.data.db.SearchDao
import com.safeboda.data.db.SearchDaoImpl
import com.safeboda.data.db.SearchDb
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(get(), SearchDb::class.java, "search.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single<SearchDao> {
        SearchDaoImpl(
            (get() as SearchDb).searchDao()
        )
    }
}