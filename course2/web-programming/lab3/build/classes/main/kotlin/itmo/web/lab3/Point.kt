package itmo.web.lab3

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name="points")
class Point(
    @Column(name = "x")
    var x: Double = .0,
    @Column(name = "y")
    var y: Double = .0,
    @Column(name = "r")
    var r: Double = .0,
    @Column(name = "currentTime")
    var currentTime: String = "",
    @Column(name = "result")
    var result: Boolean = false
) : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int = 0
    fun getColor() = if (result) "green" else "red"
}