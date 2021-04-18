package mockk

import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserServiceTest {

    @Test
    fun `getUserInfo using mockk` () {
        //given
        val mockedDbService = mockk<DbService>()
        val slot = slot<String>()
        every { mockedDbService.getDataFromDb(capture(slot)) } returns "Alice"
        val serviceUnderTest = UserService(mockedDbService)

        //when
        val result = serviceUnderTest.getUserInfo("Bob")

        //then
        verify {  mockedDbService.getDataFromDb(any())}
        assertThat(slot.captured).isEqualTo("Bob")
        assertThat(result).isEqualTo("Alice")
    }
}