package tornado

import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.text.Text
import utils.ToType

class UIAsker {
    fun <T> ask(
        printHint: String,
        errorHint: String,
        converter: ToType<T>,
        checker: (Nothing) -> Boolean
    ): HBox {
        val check = checker as (T) -> Boolean
        val hbox = HBox()
        val text = Text(printHint)
        val error = Text(errorHint)
        error.isVisible = false
        val textField = TextField()
        hbox.properties["checker"] = {s: String -> check.invoke(converter(s))}
        hbox.properties["text"] = textField
        hbox.properties["error"] = error
        hbox.children.addAll(
            text,
            error,
            textField
        )
        return hbox
    }
}

val ToIntOrNull: ToType<Int?> = { it?.toIntOrNull() }
val ToLong: ToType<Long> = { it!!.toLong() }
val ToFloat: ToType<Float> = { it!!.toFloat() }
val ToFloatOrNull: ToType<Float?> = { it?.toFloatOrNull() }
val ToDouble: ToType<Double> = { it!!.toDouble() }
val ToString: ToType<String> = { it!! }
