package org.example

import org.example.methods.lab1.chordMethod
import org.example.methods.lab1.goldenRatioMethod
import org.example.methods.lab1.halfDividingMethod
import org.example.methods.lab1.newtonMethod
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

fun main() {
    val methods = arrayListOf(
        halfDividingMethod,
        goldenRatioMethod,
        chordMethod,
        newtonMethod
        )
    methods.forEach {
        it.a = 0.0
        it.b = 1.0
        it.epsilon = 0.001
        it.function = {
            x: Double ->
            x.pow(3) - 3 * sin(x)
        }
        it.derivative = {
            x: Double ->
            3 * x.pow(2) - 3 * cos(x)
        }
        it.secondDerivative = {
            x: Double ->
            6 * x + 3 * sin(x)
        }
    }
    for (method in methods) {
        val (x, y) = method.eval()
        println("${method.name}, шагов итерации: ${method.i - 1}, x: $x, y: $y")
    }
}