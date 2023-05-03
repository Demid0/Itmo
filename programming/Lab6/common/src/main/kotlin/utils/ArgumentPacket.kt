package utils

import collectionObjectsClasses.Route
import kotlinx.serialization.Serializable

@Serializable
class ArgumentPacket(var commandName: String?, var singleArg: String?, var objectArg: Route?) {
    constructor() : this(null, null, null)
}