package systemCommands

import exceptions.SystemCommandInvocationException
import utils.argToVisibilityAndString


val setUser = SystemCommand("set_user", argToVisibilityAndString) {
        (visibility, token) ->
    try {
        condition.token = token
        condition.set(visibility)
    } catch (e: Exception) {
        throw SystemCommandInvocationException("${e::class} : ${e.message}")
    }
}