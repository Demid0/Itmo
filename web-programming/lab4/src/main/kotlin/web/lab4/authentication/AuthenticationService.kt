package web.lab4.authentication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import web.lab4.authentication.jwt.JwtService
import web.lab4.authentication.request.AuthenticationRequest
import web.lab4.authentication.response.AuthenticationResponse
import web.lab4.entities.user.Role
import web.lab4.entities.user.User
import web.lab4.repositories.UserRepository

@Service
class AuthenticationService {

    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder
    @Autowired
    private lateinit var jwtService: JwtService

    fun register(request: AuthenticationRequest): AuthenticationResponse {
        if (!userRepository.findByName(request.name).isEmpty) throw Exception("User already exists")
        val user = User()
        user.name = request.name
        user.userPassword = passwordEncoder.encode(request.userPassword)
        user.role = Role.USER
        userRepository.save(user)
        val jwtToken = jwtService.generateToken(userDetails = user)
        return AuthenticationResponse(token = jwtToken)
    }

    fun login(request: AuthenticationRequest): AuthenticationResponse {
        val user = userRepository.findByName(request.name).orElseThrow { Exception("User not found") }
        if (!passwordEncoder.matches(request.userPassword, user.userPassword)) throw Exception("Bad credentials")
        val authToken = UsernamePasswordAuthenticationToken(user, null, user.authorities)
        SecurityContextHolder.getContext().authentication = authToken
        val jwtToken = jwtService.generateToken(userDetails = user)
        return AuthenticationResponse(token = jwtToken)
    }

    fun logout(token: String): AuthenticationResponse {
        val user = userRepository.findByName(jwtService.extractUsername(token)!!).orElseThrow { Exception("Token is invalid") }
        SecurityContextHolder.getContext().authentication = null
        return AuthenticationResponse()
    }

}