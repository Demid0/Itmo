package stepik.structures

import java.util.*
import kotlin.math.max

fun main() {
    val sc = Scanner(System.`in`)
    val buffer = StringBuilder()

    val n = sc.nextInt()
    val array = ArrayList<Int>()
    for (i in 1..n) array.add(sc.nextInt())
    val m = sc.nextInt()

    val first = Stack<Pair<Int, Int>>()
    val second = Stack<Pair<Int, Int>>()

    var k = 0
    var localMax = -1
    while (first.size < m) {
        localMax = max(localMax, array[k])
        first.push(array[k] to localMax)
        k++
    }
    while (k <= n) {
        localMax = -1
        while (first.isNotEmpty()) {
            val p = first.pop()
            localMax = max(p.first, localMax)
            second.push(p.first to localMax)
        }
        localMax = -1
        while (k <= n && second.isNotEmpty()) {
            val o = max(second.pop().second, if (first.empty()) 0 else first.peek().second).toString()
            buffer.append("$o ")
            if (k < n) {
                localMax = max(localMax, array[k])
                first.push(array[k] to localMax)
            }
            k++
        }
    }

    println(buffer.toString())
}
