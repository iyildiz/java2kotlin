import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested

class FunctionsTest {

    @Nested
    inner class DefaultParameters {
        @Test
        fun `methodWithDefaultParameters called in different ordered arguments returns same value`() {
            val argumentsInRightOrder = methodWithDefaultParameters("abc", "(", ")")
            val argumentsInDifferentOrder = methodWithDefaultParameters(prefix = "(", message = "abc", suffix=")")

            assertThat(argumentsInDifferentOrder).isEqualTo(argumentsInRightOrder)
        }
    }
}