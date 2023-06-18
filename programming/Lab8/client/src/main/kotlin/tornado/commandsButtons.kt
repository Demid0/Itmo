package tornado

import commandArgumentsAndTheirsComponents.CommandType
import javafx.scene.control.Button
import tornadofx.action
import tornadofx.label
import utils.parseCommandAndAskArguments
import kotlin.collections.ArrayList
import kotlin.system.exitProcess


class CommandButton: Button() {
    var commandName: String = ""
    var args: ArrayList<Pair<Pair<String, String>, Check<*>>> = arrayListOf()
    var act : () -> Unit = {MyApp.currentPage.replaceWith(ArgumentsView(commandName, args))}
    fun  build(op: CommandButton.() -> Unit): CommandButton {
        op.invoke(this).apply {
            label(commandName)
            action {
                act.invoke()
            }
        }
        return this
    }
    fun create(): CommandButton {
        val c = CommandButton()
        c.commandName = this.commandName
        c.args = this.args
        c.act = this.act
        return c.build {}
    }

    fun setType(commandType: CommandType) { possibleTypes[commandType]?.invoke(this) }
}

fun commandButton(op: CommandButton.() -> Unit): CommandButton {
    return CommandButton().build(op)
}

var possibleTypes: HashMap<CommandType, CommandButton.() -> Unit > = hashMapOf(
    CommandType.TWO_STRINGS_ARG to {
        args.add(("username" to "lll") to Check(ToString) { it != "" } )
        args.add(("password" to "lll") to Check(ToString) { it != "" } )
    },
    CommandType.OBJECT_ARG to {
        args.add(("Route name" to "lll") to Check(ToString) { it != "" } )
        args.add(("Route coordinates - x" to "lll") to Check(ToFloatOrNull) { it == null || it <= 800 } )
        args.add(("Route coordinates - y" to "lll") to Check(ToIntOrNull) { true } )
        args.add(("Route from location - x" to "lll") to Check(ToIntOrNull) { true } )
        args.add(("Route from location - y" to "lll") to Check(ToFloat) { true } )
        args.add(("Route from location - z" to "lll") to Check(ToLong) { true } )
        args.add(("Route from location - name" to "lll") to Check(ToString) { it != "" && it.length <= 496 } )
        args.add(("Route to location - x" to "lll") to Check(ToIntOrNull) { true } )
        args.add(("Route to location - y" to "lll") to Check(ToFloat) { true } )
        args.add(("Route to location - z" to "lll") to Check(ToLong) { true } )
        args.add(("Route to location - name" to "lll") to Check(ToString) { it != "" && it.length <= 496 } )
        args.add(("Route distance" to "lll") to Check(ToDouble) { it > 1 } )
    }
)

val exitButton = commandButton {
    commandName = "exit"
    act = { exitProcess(0) }
}

val commandsButtons = HashMap<String, CommandButton>()

val commandsButtonsInit = {
    val commands = parseCommandAndAskArguments().getCommands()
    commands.forEach {
        commandsButtons[it.key] =
            commandButton {
                this.commandName = it.key
                setType(it.value)
            }
    }
}