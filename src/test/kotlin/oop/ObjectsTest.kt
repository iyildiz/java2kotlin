package oop

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ObjectsTest {

    @Test
    fun `singleton calls returns same instance`() {
        assertEquals(singleton(), singleton())
    }
}