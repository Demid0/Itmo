package utils

import commandArgumentsAndTheirsComponents.Visibility

class Condition(private var it: Visibility) {
    var clientName = "unlogged_user"
    var password = "123"

    fun set(v: Visibility) { it = v }
    fun get() = it
}
