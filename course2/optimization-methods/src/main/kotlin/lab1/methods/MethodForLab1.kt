package lab1.methods

import kotlin.math.*

class MethodForLab1(
    val name: String,
    private var execution: MethodForLab1.() -> Pair<Double, Double>
) {
    var i = 1
    var a = 0.0
    var b = 1.0
    var epsilon = 0.001
    var function = {
        x: Double ->
        x.pow(3) - 3 * sin(x)
    }
    var derivative = {
        x: Double ->
        3 * x.pow(2) - 3 * cos(x)
    }
    var secondDerivative = {
        x: Double ->
        6 * x + 3 * sin(x)
    }
    fun eval() = execution.invoke(this)
}