package lab1.methods

val goldenRatioMethod = MethodForLab1("Золотое сечение") {
    while(b - a >= epsilon) {
        val x1 = a + 0.382 * (b - a)
        val x2 = a + 0.618 * (b - a)
        val y1 = function(x1)
        val y2 = function(x2)
        //println("Шаг $i\n x1: $x1, y1: $y1\n x2: $x2, y2: $y2")
        if (y1 < y2) b = x2
        else a = x1
        //println("Новые значения\na: $a, b: $b")
        i++
    }
    (a + b) / 2 to function((a + b) / 2)
}