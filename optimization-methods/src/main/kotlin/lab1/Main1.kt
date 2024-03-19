package lab1

import lab1.methods.chordMethod
import lab1.methods.goldenRatioMethod
import lab1.methods.halfDividingMethod
import lab1.methods.newtonMethod

fun main() {
    val methods = arrayListOf(
        halfDividingMethod,
        goldenRatioMethod,
        chordMethod,
        newtonMethod
    )
    for (method in methods) {
        val (x, y) = method.eval()
        println("${method.name}, шагов итерации: ${method.i - 1}, x: $x, y: $y")
    }
}