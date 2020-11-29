package com.safeboda.githubuser.util

import com.safeboda.data.util.getCurrentTimeMillis
import com.safeboda.data.util.isCacheExpired
import org.junit.Assert.*
import org.junit.Test

class UtilTest {

    @Test
    fun `is cache expired`() {
        val currentTimeMillis = getCurrentTimeMillis()

        assertFalse(isCacheExpired(currentTimeMillis))

        val timeExpired = currentTimeMillis - 2 * 60 * 61 * 1000

        assertTrue(isCacheExpired(timeExpired))

    }

    @Test
    fun `test current time`() {
        assertNotNull(getCurrentTimeMillis())
    }

}