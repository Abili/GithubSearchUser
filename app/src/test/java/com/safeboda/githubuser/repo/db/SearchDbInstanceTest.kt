package com.safeboda.githubuser.repo.db


import com.safeboda.data.db.SearchDb
import com.safeboda.data.db.SearchDb_Impl
import org.junit.Assert
import org.junit.Test

class SearchDbInstanceTest {
    @Test
    fun `validate search dao instance are same for same session`() {
        val searchDb: SearchDb = SearchDb_Impl()
        val searchDbDao1 = searchDb.searchDao()
        Assert.assertNotNull(searchDbDao1)

        val searchDbDao2 = searchDb.searchDao()
        Assert.assertEquals(searchDbDao1, searchDbDao2)
    }
}