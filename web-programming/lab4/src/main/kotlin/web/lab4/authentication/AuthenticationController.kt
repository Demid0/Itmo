package web.lab4.authentication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import web.lab4.authentication.request.AuthenticationRequest
import web.lab4.authentication.response.AuthenticationResponse

@RestController
@RequestMapping("/auth")
class AuthenticationController(
    @Autowired private val service: AuthenticationService
) {

    @PostMapping("/register")
    fun register(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> = ResponseEntity.ok(service.register(request))

    @PostMapping("/login")
    fun login(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> = ResponseEntity.ok(service.login(request))

}