package codeforces.block1

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val buffer = StringBuilder()

    val t = sc.nextInt()
    for (i in 1..t) {
        val n = sc.nextInt()
        val str = sc.next()
        var counter = n
        val stack = Stack<Char>()
        for (j in str) {
            if (j == '(') {
                stack.push(j)
            }
            else {
                if (stack.isNotEmpty()) {
                    stack.pop()
                    counter-=2
                }
            }
        }
        counter/=2
        buffer.append("$counter\n")
    }
    println(buffer.toString())
}
