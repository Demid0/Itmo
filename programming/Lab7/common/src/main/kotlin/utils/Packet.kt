package utils

import kotlinx.serialization.Serializable
import commandArgumentsAndTheirsComponents.CommandArgument

@Serializable
open class Packet(val commandName: String, val arguments: ArrayList<CommandArgument>) {
    var token: String = "unlogged_user"
    constructor() : this("command", arrayListOf())
    fun wrapIntoArray(): ArrayList<Packet> = arrayListOf(this)
}