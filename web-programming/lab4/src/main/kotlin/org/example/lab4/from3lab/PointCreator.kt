package org.example.lab4.from3lab

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PointCreator {

    companion object {
        fun create(x: Double, y: Double, r: Double, time: String) =
            Point(
                x = x, y = y, r = r,
                time = time,
                result = isInArea(x, y, r)
            )

        private fun isInRectangle(x: Double, y: Double, r: Double) = (x in -r..0.0) && (y in 0.0..r)
        private fun isInArea(x: Double, y: Double, r: Double) = isInTriangle(x, y, r) || isInCircle(x, y, r) || isInRectangle(x, y, r)
        private fun isInCircle(x: Double, y: Double, r: Double) = (x*x + y*y <= r*r/4) && (y <= 0) && (x >= 0)
        private fun isInTriangle(x: Double, y: Double, r: Double) = (y >= - x / 2 - r / 2) && (y <= 0) && (x <= 0)
    }
}