package utils

import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandTypeArgument
import commandArgumentsAndTheirsComponents.MyString
import commandArgumentsAndTheirsComponents.Route


class Caster {
    fun toString(obj: CommandArgument) = (obj as MyString).it
    fun toCommandType(obj: CommandArgument) = (obj as CommandTypeArgument).it
    fun toRoute(obj: CommandArgument) = (obj as Route)
}