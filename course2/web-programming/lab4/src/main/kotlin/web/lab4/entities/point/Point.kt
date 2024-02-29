package web.lab4.entities.point

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity
@Table(name = "points")
class Point(
    val x: Double = 0.0,
    val y: Double = 0.0,
    val r: Double = 0.0
) : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var time: String = ""
    var result: Boolean = false
    var ownerId: Long = 0

    init {
        time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
        result = checkArea(x, y, r)
    }
    fun getColor() = if(result) "green" else "red"

    private fun checkArea(x: Double, y: Double, r: Double) = isRectangle(x, y, r) || isTriangle(x, y, r) || isCircle(x, y, r)
    private fun isRectangle(x: Double, y: Double, r: Double) = (x in (-r/2)..0.0) && (y in 0.0..r)
    private fun isTriangle(x: Double, y: Double, r: Double) = (x <= 0) && (y <= 0) && (y + x + r >= 0)
    private fun isCircle(x: Double, y: Double, r: Double) = (x >= 0) && (y >= 0) && (x * x + y * y <= r * r)
}