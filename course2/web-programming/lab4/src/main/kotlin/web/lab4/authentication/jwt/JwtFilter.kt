package web.lab4.authentication.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.lang.NonNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter: OncePerRequestFilter() {

    @Autowired
    private lateinit var jwtService: JwtService
    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    override fun doFilterInternal(
        @NonNull request: HttpServletRequest,
        @NonNull response: HttpServletResponse,
        @NonNull filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }
        val jwtToken = authHeader.substring(7)
        try {
            val username = jwtService.extractUsername(jwtToken)
            if (username != null && SecurityContextHolder.getContext().authentication == null) {
                val userDetails = userDetailsService.loadUserByUsername(username)
                if (jwtService.isTokenValid(jwtToken, userDetails)) {
                    val authToken = UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.authorities
                    ).also { it.details = WebAuthenticationDetailsSource().buildDetails(request) }
                    SecurityContextHolder.getContext().authentication = authToken
                }
            }
        } catch (e: Exception) { return }
        finally { filterChain.doFilter(request, response) }
    }

}