package itmo.web.lab3

import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named
import java.io.Serializable
import java.time.LocalDateTime

@Named
@SessionScoped
class HitChecker: Serializable {
    val history = ArrayList<Point>()
    fun check(x: Double, y: Double, r: Double) {
        println("$x, $y, $r")
        val point = Point(x, y, r, LocalDateTime.now().toString(), isInArea(x, y, r))
        history.add(point)
        showPoints(r)
    }
    fun showPoints(r: Double) = history.forEach { it.visibility = if(r == it.r) "visible" else "hidden" }
    private fun isInArea(x: Double, y: Double, r: Double) = isInTriangle(x, y, r) || isInCircle(x, y, r) || isInRectangle(x, y, r)
    private fun isInRectangle(x: Double, y: Double, r: Double) = (x in -r..0.0) && (y in 0.0..r)
    private fun isInCircle(x: Double, y: Double, r: Double) = (x*x + y*y <= r*r/4) && (y <= 0) && (x >= 0)
    private fun isInTriangle(x: Double, y: Double, r: Double) = (y >= - x / 2 - r / 2) && (y <= 0) && (x <= 0)
}