package utils

import collectionObjectsClasses.Route
import kotlinx.serialization.Serializable

@Serializable
class ArgumentPacket(var commandName: String?, var singleArg: String?, var objectArg: Route?, var commandFrom: String?) {
    constructor() : this(null, null, null, null)
}