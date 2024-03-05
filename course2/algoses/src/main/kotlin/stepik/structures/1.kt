package stepik.structures

import java.util.*

fun main() {
    println(woo(readln()))
}

fun woo(s: String): String {
    val openBraces = arrayListOf('[', '{', '(')
    val closeBraces = arrayListOf(']', '}', ')')
    val stack = Stack<Pair<Char, Int>>()
    var counter = 1
    for (i in s) {
        if (i in openBraces) {
            stack.push(i to counter)
        } else if (i in closeBraces) {
            try {
                val match = stack.peek()
                var flag = false
                for (j in 0..2) {
                    if (openBraces[j] == match.first && closeBraces[j] == i) {
                        flag = true
                        stack.pop()
                    }
                }
                if (!flag) {
                    return counter.toString()
                }
            } catch (e: Exception) { return counter.toString() }
        }
        counter++
    }
    return if (!stack.empty()) stack.first().second.toString()
    else "Success"
}