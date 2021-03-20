import io.mockk.*
import org.junit.jupiter.api.Test

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
}