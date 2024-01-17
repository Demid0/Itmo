package itmo.web.lab3

import java.io.Serializable

class Point: Serializable {
    var x = .0
    var y = .0
    var r = .0
    var currentTime = ""
    var result = false
    var color = "red"
    var visibility = "hidden"

    constructor(x: Double = .0, y: Double = .0, r: Double = .0, currentTime: String = "", result: Boolean = false) {
        this.x = x
        this.y = y
        this.r = r
        this.currentTime = currentTime
        this.result = result
        this.color = if (result) "green" else "red"
    }
}