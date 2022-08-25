package dev.floofy.utils.koin.tests

import dev.floofy.utils.koin.retrieve
import org.junit.Test
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SomeObject(val name: String, val age: Int)

class KoinExtensionsTest {
    @Test
    fun `koin tests`() {
        startKoin {
            modules(
                module {
                    single { SomeObject("Noel", 18) }
                }
            )
        }

        assertTrue(GlobalContext.getKoinApplicationOrNull() != null)
        val obj: SomeObject = GlobalContext.retrieve()

        assertContains(obj.name, "Noel")
        assertEquals(18, obj.age)
    }
}
