package utils

import commandArgumentsAndTheirsComponents.*


class Caster {
    fun toString(obj: CommandArgument) = (obj as MyString).it
    fun toCommandType(obj: CommandArgument) = (obj as CommandTypeArgument).it
    fun toRoute(obj: CommandArgument) = (obj as Route)

    fun toVisibility(obj: CommandArgument) = (obj as VisibilityArgument).it
}