package itmo.web.lab3

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name="points")
@NamedQuery(name = "Point.getAll", query = "SELECT p from Point p")
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
    @Column(name = "color")
    var color = "red"
    @Transient
    var visibility = "hidden"

    init {
        this.color = if (result) "green" else "red"
    }
}