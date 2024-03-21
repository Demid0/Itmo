package codeforces.block2

fun main() {
    val (a, b) = readln().split(" ")
    var ans = ""
    for (s in a) {
        if (ans != "" && s >= b[0]) {
            ans += b[0]
            break
        } else ans += s
    }
    if (ans.last() != b[0] || ans.length == 1) ans += b[0]
    println(ans)
}