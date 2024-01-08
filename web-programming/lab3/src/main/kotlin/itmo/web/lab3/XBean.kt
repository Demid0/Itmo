package itmo.web.lab3

import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named
import java.io.Serializable

@Named
@SessionScoped
class XBean : Serializable {
    var value = Double.NaN
    val possibleValues = List(9) { ((it - 4).toDouble() / 2) }
    fun isValid() = !value.isNaN() && possibleValues.contains(value)
}