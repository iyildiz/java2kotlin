import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows

class IdiomsTest {

    @Nested
    inner class Nullability {
        @Test
        fun `validateJavaCustomer throws Exception`() {
            val customerJava = CustomerJava()
            customerJava.name = "Abc"
            assertThrows<Exception> {
                validateJavaCustomer(customerJava)
            }
        }

        @Test
        fun `validateJavaCustomer does not exception for null customer`() {
            validateJavaCustomer(null)
        }

        @Test
        fun `validateJavaCustomer does not exception for null name`() {
            validateJavaCustomer(CustomerJava())
        }

        @Test
        fun `validateCustomer throws Exception`() {
            val customer = IdiomsCustomer(12, "Abc")
            assertThrows<Exception> {
                validateCustomer(customer)
            }
        }

        @Test
        fun `validateCustomer does not throw Exception`() {
            validateCustomer(IdiomsCustomer(12, "bc"))
        }

        @Test
        fun `nullableCustomer with non null value`() {

            val nullableCustomer : IdiomsCustomer? = IdiomsCustomer(4, "not null")
            val result = nullableCustomer?.hasEvenId() ?: false
            assertThat(result).isEqualTo(true)
        }

        @Test
        fun `nullableCustomer with null value`() {

            val nullableCustomer : IdiomsCustomer? = null
            val result = nullableCustomer?.hasEvenId() ?: false
            assertThat(result).isEqualTo(false)
        }

        @Test
        fun `not-null assertion operator throws KotlinNullPointerException for null values`() {
            val nullableCustomer : IdiomsCustomer? = null
            assertThrows<KotlinNullPointerException> {
                nullableCustomer!!.name
            }
        }

        @Test
        fun `not-null assertion operator does not throw Exception for non null values`() {
            val nullableCustomer : IdiomsCustomer? = IdiomsCustomer(5, "not null")

            nullableCustomer!!.name
        }
    }
}