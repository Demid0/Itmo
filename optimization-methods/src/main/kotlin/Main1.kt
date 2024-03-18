package org.example

import org.example.methods.lab1.chordMethod
import org.example.methods.lab1.goldenRatioMethod
import org.example.methods.lab1.halfDividingMethod
import org.example.methods.lab1.newtonMethod

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