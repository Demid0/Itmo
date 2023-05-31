package utils

import kotlinx.serialization.Serializable
import commandArgumentsAndTheirsComponents.CommandArgument

@Serializable
open class Packet(val commandName: String, val arguments: ArrayList<CommandArgument>) {
    var clientName: String = "unlogged_user"
    var password: String = "123"
    constructor() : this("command", arrayListOf())
    fun wrapIntoArray(): ArrayList<Packet> = arrayListOf(this)
}