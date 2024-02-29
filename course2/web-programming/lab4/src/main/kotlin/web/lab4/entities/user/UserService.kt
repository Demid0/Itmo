package web.lab4.entities.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import web.lab4.authentication.jwt.JwtService
import web.lab4.repositories.UserRepository

@Service
class UserService {
    @Autowired
    private lateinit var jwtService: JwtService
    @Autowired
    private lateinit var userRepository: UserRepository

    fun getByToken(token: String): User {
        return userRepository.findByName(jwtService.extractUsername(token.split(" ")[1]).orEmpty()).orElseThrow { Exception("Bad token") }
    }


}
