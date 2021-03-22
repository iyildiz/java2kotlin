import io.mockk.*
import oop.Customer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger

class variablesTest {
    @Test
    fun `lazyLoadUser calls services in the right order`() {
        val mockUserService = mockk<UserService>()
        every { mockUserService.initUser() } just Runs
        every { mockUserService.reload() }  returns  Unit
        justRun { mockUserService.save(any()) }

        lazyLoadUser(mockUserService, "lazyUserName")

        verifySequence {
            mockUserService.reload()
            mockUserService.initUser()
            mockUserService.save("lazyUserName")
        }
    }

    @Test
    fun `lazyLoadUser calls services in the right order using relaxed = true`() {

        val mockUserService = mockk<UserService>(relaxed = true)
        lazyLoadUser(mockUserService, "lazyUserName")

        verifySequence {
            mockUserService.reload()
            mockUserService.initUser()
            mockUserService.save("lazyUserName")
        }
    }

    @Test
    fun `lazy block is used only once`() {

        val numOfInits = AtomicInteger()
        val lazyValue: Customer by lazy {
            numOfInits.incrementAndGet()
            Customer(1, "name", "email")
        }

        lazyValue
        lazyValue

        assertThat(numOfInits.get()).isEqualTo(1)
    }
}