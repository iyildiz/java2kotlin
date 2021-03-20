import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested

class IdiomsTest {

    @Nested
    inner class Nullability {
        @Test
        fun `orderedSquaresForFactorsOf returns right values`() {

            val randomNumbers = (1..100).shuffled().toList()
            val first = orderedSquaresForFactorsOf(randomNumbers, 50)
            assertThat(first).isEqualTo(listOf(50*50, 100*100))
        }
    }
}