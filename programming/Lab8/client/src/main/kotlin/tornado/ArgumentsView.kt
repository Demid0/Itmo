package tornado

import clientMessageHandler
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.text.Text
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tornadofx.View
import tornadofx.action
import tornadofx.vbox
import utils.ToType
import utils.parseCommandAndAskArguments

class ArgumentsView(commandName: String, args: ArrayList<Pair<Pair<String, String>, Check<*>>>): View(commandName),
    KoinComponent {
    private val parseCommandAndAskArguments by inject<parseCommandAndAskArguments>()
    private val asker by inject<UIAsker>()
    override val root = vbox {
        spacing = 10.0
        val button = Button("Enter")
        val argumentsFields = args.map { asker.ask(it.first.first, it.first.second, it.second.caster, it.second.checker) }
        val checkersAndInput = argumentsFields.map { it to it.properties["checker"] as (input: String) -> Boolean to it.properties["text"] as TextField }
        button.action {
            val check = checkersAndInput.associate { it.first.first to it.first.second.invoke(it.second.text) }
            if (check.values.contains(false)) {
                check.filter{ !it.value }.forEach {
                    (it.key.properties["error"] as Text).isVisible = true
                }
                check.filter{ it.value }.forEach {
                    (it.key.properties["error"] as Text).isVisible = false
                }
            }
            else {
                val array = arrayListOf(commandName)
                array.addAll(
                    check.map {
                        p -> (p.key.properties["text"] as TextField).text
                    }.toMutableList()
                )
                val packet = parseCommandAndAskArguments.UIparse(array)
                clientMessageHandler.run(packet)
            }
        }

        this.children.addAll(argumentsFields)
        this.children.add(button)
    }
}

class Check<T>(var caster: ToType<T>, var checker: (input: T) -> Boolean)