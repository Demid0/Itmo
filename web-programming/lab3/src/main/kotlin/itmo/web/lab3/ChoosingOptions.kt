package itmo.web.lab3

import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named
import java.io.Serializable

@Named("choosingOptions")
@SessionScoped
class ChoosingOptions: Serializable {

    val xValues = List(10) { ((it - 5).toDouble() / 2) }
    val rValues = List(5)  { it + 1 }

}