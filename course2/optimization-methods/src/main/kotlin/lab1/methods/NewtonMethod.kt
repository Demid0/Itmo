package lab1.methods

import kotlin.math.abs

val newtonMethod = MethodForLab1("Ньютон") {
    var x = (a + b) / 2
    while (abs(derivative(x)) > epsilon) {
        //println("Шаг $i - x: $x")
        x -= derivative(x) / secondDerivative(x)
        i++
    }
    x to function(x)
}