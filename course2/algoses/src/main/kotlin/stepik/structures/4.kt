package stepik.structures

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val stack = Stack<Int>()
    val queue = Stack<Int>()
    val buffer = StringBuilder()

    for (i in 1..n) {
        when(sc.next()) {
            "push" -> {
                stack.push(sc.nextInt())
                queue.push(if (queue.empty() || queue.peek() < stack.peek()) stack.peek() else queue.peek())
            }
            "pop" -> {
                stack.pop()
                queue.pop()
            }
            "max" -> buffer.append(queue.peek().toString() + "\n")
        }
    }
    println(buffer.toString())
}
