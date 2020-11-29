package com.safeboda.githubuser.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.safeboda.githubuser.di.appModule
import com.safeboda.githubuser.di.dbModule
import com.safeboda.domain.repository.SearchRepository
import com.safeboda.githubuser.di.networkModule
import com.safeboda.githubuser.models.Resource
import com.safeboda.githubuser.testFollowerList
import com.safeboda.githubuser.testFollowingList
import com.safeboda.githubuser.testUser
import com.safeboda.githubuser.userName
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class SearchViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val repo = mockk<SearchRepository>(relaxed = true)


    @Before
    fun setup() {
        stopKoin()
        startKoin {
            listOf(dbModule, networkModule, appModule)
        }

    }

    @After
    fun close() {
        stopKoin()
    }

    @Test
    fun `validate user details and live data when success`() {
        val viewModel = SearchViewModel(repo)

        coEvery { repo.getUser(userName) }.returns(testUser)
        coEvery { repo.getUserFollowers(userName) }.returns(testFollowerList)
        coEvery { repo.getUserFollowing(userName) }.returns(testFollowingList)

        viewModel.getUserDetails(userName)

        val resource = viewModel.userLiveData.value

        assert(resource is Resource.Success)

        val details = resource?.data

        assertNotNull(details?.user)
        assertEquals(2, details?.followers?.size)
        assertEquals(2, details?.following?.size)
    }

    @Test
    fun `validate user details and live data when user is null`() {
        val viewModel = SearchViewModel(repo)

        coEvery { repo.getUser(userName) }.returns(null)
        coEvery { repo.getUserFollowers(userName) }.returns(emptyList())
        coEvery { repo.getUserFollowing(userName) }.returns(emptyList())

        viewModel.getUserDetails(userName)

        val resource = viewModel.userLiveData.value

        assert(resource is Resource.Error)

    }

    @Test
    fun `validate follower live data value success`() {
        val viewModel = SearchViewModel(repo)

        coEvery { repo.getUser(userName) }.returns(testUser)
        coEvery { repo.getUserFollowers(userName) }.returns(testFollowerList)
        coEvery { repo.getUserFollowing(userName) }.returns(testFollowingList)

        viewModel.getUserDetails(userName)
        viewModel.getUserFollowers()

        val resource = viewModel.followerLiveData.value

        assert(resource is Resource.Success)
        assertEquals(2, resource?.data?.size)


    }

    @Test
    fun `validate follower live data empty list value`() {
        val viewModel = SearchViewModel(repo)

        coEvery { repo.getUser(userName) }.returns(null)
        coEvery { repo.getUserFollowers(userName) }.returns(emptyList())
        coEvery { repo.getUserFollowing(userName) }.returns(emptyList())

        viewModel.getUserDetails(userName)
        viewModel.getUserFollowers()

        val resource = viewModel.followerLiveData.value

        assert(resource is Resource.Error)

    }


    @Test
    fun `validate following live data value success`() {
        val viewModel = SearchViewModel(repo)

        coEvery { repo.getUser(userName) }.returns(testUser)
        coEvery { repo.getUserFollowers(userName) }.returns(testFollowerList)
        coEvery { repo.getUserFollowing(userName) }.returns(testFollowingList)

        viewModel.getUserDetails(userName)
        viewModel.getUserFollowing()

        val resource = viewModel.followingLiveData.value

        assert(resource is Resource.Success)
        assertEquals(2, resource?.data?.size)


    }

    @Test
    fun `validate following live data empty list value`() {
        val viewModel = SearchViewModel(repo)

        coEvery { repo.getUser(userName) }.returns(null)
        coEvery { repo.getUserFollowers(userName) }.returns(emptyList())
        coEvery { repo.getUserFollowing(userName) }.returns(emptyList())

        viewModel.getUserDetails(userName)
        viewModel.getUserFollowing()

        val resource = viewModel.followingLiveData.value

        assert(resource is Resource.Error)

    }

}