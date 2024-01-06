package itmo.web.lab3

import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named
import java.io.Serializable

@Named
@SessionScoped
class Chosen : Serializable {
    var x = .0
    var y = ""
    var r = 0

    val xValues = List(9) { ((it - 4).toDouble() / 2) }
    val rValues = List(5)  { it + 1 }

    fun xIsValid() = !x.isNaN() && xValues.contains(x)
    fun yIsValid() = y.isNotEmpty() && y.isNotBlank() && (-3 <= y.toDouble() && y.toDouble() <= 5)
    fun rIsValid() = rValues.contains(r)

}