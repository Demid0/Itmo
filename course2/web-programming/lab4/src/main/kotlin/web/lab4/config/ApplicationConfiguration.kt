package web.lab4.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import web.lab4.repositories.UserRepository

@Configuration
class ApplicationConfiguration {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Bean
    fun getUserDetailsService(): UserDetailsService = UserDetailsService {
        username: String -> userRepository.findByName(username).orElseThrow { UsernameNotFoundException("User not found") }
    }

    @Bean
    fun getAuthenticationProvider(): AuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(getUserDetailsService())
        provider.setPasswordEncoder(getPasswordEncoder())
        return provider
    }

    @Bean
    fun getPasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}