package itmo.web.lab3

import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named
import java.io.Serializable

@Named
@SessionScoped
class Chosen : Serializable {
    var x: Double = .0
    var y: String = ""
    var r: Double = .0
}