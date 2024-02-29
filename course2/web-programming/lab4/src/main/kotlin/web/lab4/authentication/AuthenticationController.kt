package web.lab4.authentication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import web.lab4.authentication.request.AuthenticationRequest
import web.lab4.authentication.response.AuthenticationResponse

@RestController
@RequestMapping("/auth")
class AuthenticationController {

    @Autowired
    private lateinit var service: AuthenticationService

    @PostMapping("/register")
    fun register(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return try {
            ResponseEntity.ok(service.register(request))
        } catch (e: Exception) {
            ResponseEntity(AuthenticationResponse(message = e.message.orEmpty()), HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse>{
        return try {
            ResponseEntity.ok(service.login(request))
        } catch (e: Exception) {
            ResponseEntity(AuthenticationResponse(message = e.message.orEmpty()), HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/logout")
    fun logout(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String): ResponseEntity<AuthenticationResponse> {
        return try {
            ResponseEntity.ok(service.logout(token.split(" ")[1]))
        } catch (e: Exception) {
            ResponseEntity(AuthenticationResponse(message = e.message.orEmpty()), HttpStatus.BAD_REQUEST)
        }
    }

}