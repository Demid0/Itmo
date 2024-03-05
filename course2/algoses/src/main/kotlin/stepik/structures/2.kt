package stepik.structures

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    val array = readArr()
    val map = HashMap<Int, Int>()
    map[-1] = 1
    array.forEach { iterate(it, array, map) }
    println(map.values.max())
}

fun readArr() : ArrayList<Int> {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val array = arrayListOf<Int>()
    for (i in 1..n) array.add(sc.nextInt())
    return array
}

fun iterate(key: Int, array: ArrayList<Int>, map: HashMap<Int, Int>) {
    if (map[key] == null) {
        if (map[array[key]] == null) iterate(array[key], array, map)
        map[key] = map[array[key]]!! + 1
    }
}