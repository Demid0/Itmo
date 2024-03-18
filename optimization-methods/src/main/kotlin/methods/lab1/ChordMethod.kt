package org.example.methods.lab1

import kotlin.math.*

val chordMethod = MethodForLab1("Метод хорд") {
    val ans: Pair<Double, Double>
    while(true) {
        val x = a - (derivative(a) * (a - b)) / (derivative(a) - derivative(b))
        val y = derivative(x)
        //println("Шаг $i\n x: $x, y: $y")
        if (abs(y) <= epsilon) {
            ans = x to function(x)
            break
        }
        else if (y > 0) b = x
        else a = x
        //println("Новые значения\na: $a, b: $b")
        i++
    }
    ans
}