package lab1.methods

val halfDividingMethod = MethodForLab1("Серединное деление") {
    while (b - a > 2 * epsilon) {
        val x1 = (a + b - epsilon) / 2
        val x2 = (a + b + epsilon) / 2
        val y1 = function(x1)
        val y2 = function(x2)
        //println("Шаг $i\n x1: $x1, y1: $y1\n x2: $x2, y2: $y2")
        if (y1 > y2) a = x1
        else b = x2
        //println("Новые значения\na: $a, b: $b")
        i++
    }
    (a + b) / 2 to function((a + b) / 2)
}
