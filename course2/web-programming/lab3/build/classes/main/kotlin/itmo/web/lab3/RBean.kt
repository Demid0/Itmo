package itmo.web.lab3

import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named
import java.io.Serializable

@Named
@SessionScoped
class RBean: Serializable {
    var value: Double = Double.NaN
    val possibleValues = List(5) { (it + 1).toDouble() }
    fun isValid() = !value.isNaN() && possibleValues.contains(value)
}