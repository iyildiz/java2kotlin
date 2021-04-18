package mockk

class DbService {
    fun getDataFromDb(userName: String): String {
        return "user: $userName"
    }
}

class UserService(val dbService: DbService) {
    fun getUserInfo(userName: String): String {
        return dbService.getDataFromDb(userName)
    }
}
