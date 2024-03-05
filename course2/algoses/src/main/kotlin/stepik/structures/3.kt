package stepik.structures

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val buffSize = sc.nextInt()
    val n = sc.nextInt()
    val input = ArrayList<Pair<Int, Int>>()
    for (i in 1..n) input.add(sc.nextInt() to sc.nextInt())
    val queue = ArrayDeque<Int>()
    var currentTime = 0

    for (i in 1..n) {
        val (arrival, duration) = input[i - 1]

        while(!queue.isEmpty() && queue.peek() <= arrival) queue.poll()

        if (currentTime < arrival) {
            println(arrival)
            currentTime = arrival + duration
            queue.add(currentTime)
        }
        else if (queue.size < buffSize) {
            println(currentTime)
            currentTime += duration
            queue.add(currentTime)
        }
        else println(-1)
    }
}
