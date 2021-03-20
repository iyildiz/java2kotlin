import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

class TypesTest {

    @Nested
    inner class Arrays {
        @Test
        fun `== & === does reference check as Kotlin arrays are converted to Java arrays`() {
            val first = initIntArray(1, 2, 3)
            val second = initIntArray(1, 2, 3)
            assertFalse(first == second)
            assertFalse(first === second)
        }

        @Test
        fun `contentEquals can be used for arrays`() {
            val first = initIntArray(1, 2, 3)
            val second = initIntArray(1, 2, 3)
            assertTrue(first.contentEquals(second))
        }
    }
}