package web.lab4.authentication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import web.lab4.authentication.jwt.JwtService
import web.lab4.authentication.request.AuthenticationRequest
import web.lab4.authentication.response.AuthenticationResponse
import web.lab4.entities.Role
import web.lab4.entities.User
import web.lab4.repositories.UserRepository

@Service
class AuthenticationService(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val passwordEncoder: PasswordEncoder,
    @Autowired private val jwtService: JwtService
) {


    fun register(request: AuthenticationRequest): AuthenticationResponse {
        if (!userRepository.findByName(request.name).isEmpty) throw Exception("User already exists")
        val user = User()
        user.name = request.name
        user.userPassword = passwordEncoder.encode(request.userPassword)
        user.role = Role.USER
        userRepository.save(user)
        val jwtToken = jwtService.generateToken(userDetails = user)
        return AuthenticationResponse(jwtToken)
    }

    fun login(request: AuthenticationRequest): AuthenticationResponse {
        val user = userRepository.findByName(request.name).orElseThrow { UsernameNotFoundException("User not found") }
        if (passwordEncoder.matches(request.userPassword, user.userPassword)) throw BadCredentialsException("Bad credentials")
        val authToken = UsernamePasswordAuthenticationToken(user, null, user.authorities)
        SecurityContextHolder.getContext().authentication = authToken
        val jwtToken = jwtService.generateToken(userDetails = user)
        return AuthenticationResponse(jwtToken)
    }

}