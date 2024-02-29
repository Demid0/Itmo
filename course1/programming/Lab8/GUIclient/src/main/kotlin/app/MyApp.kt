package app

import javafx.beans.property.SimpleStringProperty
import tornadofx.App
import views.StartScreen
import java.util.*

class MyApp: App(StartScreen::class, Style::class) {
    companion object {
        var bundle = ResourceBundle.getBundle("messages", Locale("ru"), ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_PROPERTIES))
        fun getString(vararg strings: String): String {
            var out = ""
            strings.forEach { out += bundle.getString(it) + " "}
            return out.dropLast(1)
        }
        val usernameProperty = SimpleStringProperty()
    }
}