package web.lab4.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import web.lab4.authentication.jwt.JwtFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Autowired
    private lateinit var jwtFilter: JwtFilter
    @Autowired
    private lateinit var authenticationProvider: AuthenticationProvider

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain = http
        .csrf{ csrf -> csrf.disable() }
        .authorizeHttpRequests { it
            .requestMatchers("/auth/logout").authenticated()
            .requestMatchers("/auth/**").anonymous()
            .requestMatchers("/controller/**").authenticated()
            .requestMatchers("/controller").authenticated()
            .anyRequest().permitAll()
        }
        .sessionManagement{it
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
        .build()

}