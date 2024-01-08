package itmo.web.lab3

import jakarta.enterprise.context.RequestScoped
import jakarta.inject.Named
import java.io.Serializable

@Named
@RequestScoped
class HitChecker: Serializable {
    fun check(x: Double, y: Double, r: Double) {
        println("$x, $y, $r")
    }
}