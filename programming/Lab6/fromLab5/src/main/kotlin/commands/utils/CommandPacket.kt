package commands.utils

import collectionObjectsClasses.Route

class CommandPacket(val command: Command, var singleArg: String?, var objectArg: Route?)
