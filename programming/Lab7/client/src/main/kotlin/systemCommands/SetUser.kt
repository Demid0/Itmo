package systemCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.MyString
import commandArgumentsAndTheirsComponents.Visibility

class SetUser: SystemCommand(CommandType.VISIBILITY_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>) {
        val visibility : Visibility = cast(arguments)
        condition.token = (arguments[1] as MyString).it
        condition.set(visibility)
    }
}