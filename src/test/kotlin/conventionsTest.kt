import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConventionsTest {
    @Test
    fun `custom inline to creates same Pair as library to`() {

        val pairWithLibraryTo = Rational(1,3) to Rational(3,4)
        val pairWithCustomTo = Rational(1,3) customTo Rational(3,4)
        assertThat(pairWithCustomTo).isEqualTo(pairWithLibraryTo)
    }
}