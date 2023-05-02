package commands.utils

import collectionObjectsClasses.Route
import kotlinx.serialization.Serializable

@Serializable
class CommandPacket(var command: Command?, var singleArg: String?, var objectArg: Route?) {
    constructor() : this(null, null, null)
}