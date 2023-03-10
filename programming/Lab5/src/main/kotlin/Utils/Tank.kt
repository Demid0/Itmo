package Utils

import Serialization.Serializator
import Utils.Asker
import Utils.Data
import Utils.Invoker

class Tank(
    var invoker: Invoker,
    var data: Data,
    var serializator: Serializator,
    var asker: Asker
)
