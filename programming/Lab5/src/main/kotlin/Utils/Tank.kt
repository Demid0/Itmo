package Utils

import Serialization.Serializator
import java.io.BufferedReader
import java.io.PrintWriter
import java.util.*

class Tank(
    var invoker: Invoker,
    var data: Data,
    var serializator: Serializator,
    var asker: Asker,
    var reader: BufferedReader,
    var writer: PrintWriter
) {
    var scriptStack = Stack<String>()
}
