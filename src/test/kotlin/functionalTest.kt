import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested

class FunctionalTest {

    @Nested
    inner class Lambdas {
        @Test
        fun `orderedSquaresForFactorsOf returns right values`() {

            val randomNumbers = (1..100).shuffled().toList()
            val first = orderedSquaresForFactorsOf(randomNumbers, 50)
            assertThat(first).isEqualTo(listOf(50*50, 100*100))
        }
    }

    @Nested
    inner class Collections {
        @Test
        fun factorialWithFold() {
            assertThat(factorialWithFold(4)).isEqualTo(24)
        }
        @Test
        fun factorialWithFoldRight() {
            assertThat(factorialWithFoldRight(4)).isEqualTo(24)
        }
        @Test
        fun addNumbersUpToWithReduce() {
            assertThat(addNumbersUpToWithReduce(4)).isEqualTo(10)
        }
        @Test
        fun factorialWithReduceRight() {
            assertThat(factorialWithReduceRight(4)).isEqualTo(24)
        }
    }
}