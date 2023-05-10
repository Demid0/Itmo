package systemCommands

import utils.CommandType
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class ReadFromFile : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        try {
            var fileName = singleArg!!
            val file = File(fileName)
            val reader = BufferedReader(InputStreamReader(FileInputStream(file)))
            fileName = file.absolutePath
            if (scriptStack.contains(fileName)) return false
            readerManager.set(reader)
            if (!scriptStack.contains(fileName)) {
                scriptStack.addLast(fileName)
                readerStack[fileName] = reader
            }
            return true
        } catch (_: Exception) {
            return false
        }
    }
}
