package dev.floofy.utils.java.tests

import dev.floofy.utils.java.SetOnceGetValue
import dev.floofy.utils.java.setOnceGetValue
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class SetOnceGetValueExtensionsTest {
    @Test
    fun `if setOnceGetValue delegate works`() {
        val owo: SetOnceGetValue<String> by setOnceGetValue()
        assertNull(owo.valueOrNull)

        owo.value = "true"
        assertEquals("true", owo.value)
    }
}
