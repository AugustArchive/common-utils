package dev.floofy.utils.kotlin.tests

import dev.floofy.utils.kotlin.*
import org.junit.Test
import kotlin.test.assertEquals

class ExtensionsTest {
    @Test
    fun `Long#sizeToStr`() {
        assertEquals(1L.sizeToStr(), "1B")
        assertEquals(12L.sizeToStr(true), "12 bytes")

        assertEquals(1L.gigabytes.sizeToStr(), "1GiB")
        assertEquals(12L.gigabytes.sizeToStr(true), "12 gigabytes")

        assertEquals(1L.terabytes.sizeToStr(), "1TiB")
        assertEquals(12L.terabytes.sizeToStr(true), "12 terabytes")
    }

    @Test
    fun `Long#humanize`() {
        assertEquals(4161800253L.humanize(long = false, true), "1mo6w18d4h3m20s")
        assertEquals(4161800253L.humanize(long = true, true), "1 month, 6 weeks, 18 days, 4 hours, 3 minutes, 20 seconds")
    }
}
