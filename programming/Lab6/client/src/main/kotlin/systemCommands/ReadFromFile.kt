package systemCommands

import utils.CommandType
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class ReadFromFile : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        try {
            val fileName = singleArg!!
            if (scriptStack.contains(fileName) && scriptStack.last() != fileName) return false
            else if (!scriptStack.contains(fileName)) scriptStack.add(fileName)
            readerManager.set(BufferedReader(InputStreamReader(FileInputStream(fileName))))
            return true
        } catch (_: Exception) {
            return false
        }
    }
}
