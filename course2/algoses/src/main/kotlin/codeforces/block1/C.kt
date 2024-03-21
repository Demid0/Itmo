package codeforces.block1

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.nextLine().replace(" ", "")
    val n = str.split('=')[1].toLong()
    var plus: Long = str.count { it == '+' }.toLong() + 1
    var minus: Long = str.count { it == '-' }.toLong()
    val min = plus - n * minus
    val max = plus * n - minus

    if (n !in min..max) {
        println("Impossible")
        return
    }
    println("Possible")
    val ans = StringBuilder()
    var curr: Long = 0
    for (i in str.indices) {
        if (str[i] == '?') {
            if (i > 0 && str[i - 1] == '-') {
                if (minus == 1.toLong() && plus == 0.toLong()) {
                    ans.append("- ${curr - n} ")
                    break
                }
                minus--
                for (x in 1..n) {
                    if (curr - x + plus - n * minus <= n && n <= curr - x + n * plus - minus) {
                        curr -= x
                        ans.append("- $x ")
                        break
                    }
                }
            }
            else {
                if (plus == 1.toLong() && minus == 0.toLong()) {
                    ans.append("+ ${n - curr} ")
                    break
                }
                plus--
                for (x in 1..n) {
                    if (curr + x + plus - n * minus <= n && n <= curr + x + n * plus - minus) {
                        curr += x
                        ans.append("+ $x ")
                        break
                    }
                }
            }
        }
    }
    ans.append("= $n")
    println(ans.toString().substring(2))
}