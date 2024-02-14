package web.lab4.repositories

import org.springframework.data.jpa.repository.JpaRepository
import web.lab4.entities.user.User
import java.util.*

interface UserRepository: JpaRepository<User, Long> {
    fun findByName(username: String): Optional<User>
}