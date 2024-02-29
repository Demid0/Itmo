package web.lab4.authentication.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*

@Service
class JwtService {
    companion object {
        private const val SECRET_KEY = "efb8ae98746c71ff025b071f89a42b20329c716cb0cc042fd14d480f5a6841a9"
        private const val VALID_TIME = 1000 * 60 * 24
    }

    fun extractUsername(token: String): String? {
        return extractAllClaims(token).subject
    }

    fun generateToken(claims: Map<String, Any> = HashMap(), userDetails: UserDetails) = Jwts
        .builder()
        .setClaims(claims)
        .setSubject(userDetails.username)
        .setIssuedAt(Date(System.currentTimeMillis()))
        .setExpiration(Date(System.currentTimeMillis() + VALID_TIME))
        .signWith(SignatureAlgorithm.HS256, getSignInKey())
        .compact()

    fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)
        return username == userDetails.username && !isTokenExpired(token)
    }

    private fun isTokenExpired(token: String) = extractAllClaims(token).expiration.before(Date())

    private fun extractAllClaims(token: String) = Jwts.parser().setSigningKey(getSignInKey()).parseClaimsJws(token).body

    private fun getSignInKey(): Key {
        val bytes = Decoders.BASE64.decode(SECRET_KEY)
        return Keys.hmacShaKeyFor(bytes)
    }

}
