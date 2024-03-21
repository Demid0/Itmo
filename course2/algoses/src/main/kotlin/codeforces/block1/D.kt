package codeforces.block1

import java.util.*
import kotlin.collections.HashMap

fun main () {
    val sc = Scanner(System.`in`)
    val t = sc.nextLong()
    for (index in 1..t) {
        val n = sc.nextInt()
        val mat = HashMap<Int, Int>()
        for (i in 1..n) {
            var a = sc.nextInt()
            var j = 2
            while (j * j <= a) {
                while (a % j == 0) {
                    if (mat[j] != null) mat[j] = mat[j]!! + 1
                    else mat[j] = 1
                    a /= j
                }
                j++
            }
            if (a > 1) {
                if (mat[a] != null) mat[a] = mat[a]!! + 1
                else mat[a] = 1
            }
        }
        var flag = true
        for (pair in mat) {
            if (pair.value % n != 0) {
                flag = false
                break
            }
        }
        if (flag) println("yes")
        else println("no")
    }
}