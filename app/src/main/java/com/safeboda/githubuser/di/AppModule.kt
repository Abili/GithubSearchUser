package com.safeboda.githubuser.di

import com.safeboda.data.repository.SearchRepositoryImpl
import com.safeboda.domain.repository.SearchRepository
import com.safeboda.githubuser.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<SearchRepository> {
        SearchRepositoryImpl(
            get(),
            get(),
            get()
        )
    }
    viewModel { SearchViewModel(get()) }
}