package org.example.lab4.from3lab

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name="points")
data class Point(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    var x: Double = .0,
    var y: Double = .0,
    var r: Double = .0,
    var result: Boolean = false,
    var time: String = ""
) : Serializable