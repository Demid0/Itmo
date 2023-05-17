package utils

import kotlinx.serialization.Serializable
import commandArgumentsAndTheirsComponents.CommandArgument

@Serializable
class Packet(val commandName: String, val arguments: ArrayList<CommandArgument>) {
    constructor() : this("command", arrayListOf())
}