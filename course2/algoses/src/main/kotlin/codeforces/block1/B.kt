package codeforces.block1

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt().toLong()

    val sum: Long = 2*n-1
    var flag = true
    for (i in sum.toString()) {
        if (i != '9') {
            flag = false
            break
        }
    }
    if (flag) {
        println(1)
        return
    }
    val len = sum.toString().length - 1
    if (len == 0) {
        println(n * (n - 1) / 2)
        return
    }
    var cur: Long = 0
    var counter = 1
    for (i in 1..len) {
        cur *= 10
        counter *= 10
        cur += 9
    }
    var ans: Long = 0
    var i = 0
    while (true) {
        val p = cur + i * counter
        ans += if (p <= n) p / 2
        else if (p > sum) break
        else (n - (p - n) + 1) / 2
        i++
    }
    println(ans)
}
