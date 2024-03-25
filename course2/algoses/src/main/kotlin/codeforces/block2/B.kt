package codeforces.block2

import java.util.Scanner

class Point (var weight: Long, var position: Long, var id: Int)

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (abc in 1..t) {
        var array: MutableList<Point> = ArrayList()
        val n = sc.nextInt()
        val m = sc.nextInt()
        for (i in 0..<m) array.add(Point(position = sc.nextLong(), weight = sc.nextLong(), id = i + 1))
        array.sortBy { it.weight }
        array = array.subList(0, 2 * n)
        array.sortBy { it.position }
        println(array.sumOf { it.weight })
        for (i in 0..<n) println("${array[i].id} ${array[2 * n - i - 1].id}")
    }
}