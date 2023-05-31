package utils

import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Route
import commandArgumentsAndTheirsComponents.Visibility
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class Command(val commandType: CommandType): KoinComponent {
    private val caster: Caster by inject()
    private val noArg: (a: ArrayList<CommandArgument>) -> Unit = {}
    private val singleArg: (a: ArrayList<CommandArgument>) -> String = { a -> caster.toString(a[0]) }
    private val objectsArg: (a: ArrayList<CommandArgument>) -> Route = { a -> caster.toRoute(a[0]) }
    private val mixedArg: (a: ArrayList<CommandArgument>) -> Pair<String, Route> = { a -> caster.toString(a[0]) to caster.toRoute(a[1]) }
    private val commandArg: (a: ArrayList<CommandArgument>) -> Pair<String, CommandType> = { a -> caster.toString(a[0]) to caster.toCommandType(a[1]) }
    private val twoStringArg: (a: ArrayList<CommandArgument>) -> Pair<String, String> = { a -> caster.toString(a[0]) to caster.toString(a[1]) }
    private val visibilityArg: (a: ArrayList<CommandArgument>) -> Visibility = { a -> caster.toVisibility(a[0]) }
    fun <T> cast(args: ArrayList<CommandArgument>) : T {
        return when(commandType) {
            CommandType.SINGLE_ARG -> singleArg
            CommandType.OBJECT_ARG -> objectsArg
            CommandType.MIXED_ARG -> mixedArg
            CommandType.COMMAND_ARG -> commandArg
            CommandType.TWO_STRINGS_ARG -> twoStringArg
            CommandType.VISIBILITY_ARG -> visibilityArg
            CommandType.NO_ARG -> noArg
        }.invoke(args) as T
    }
}