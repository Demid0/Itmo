package systemCommands

import utils.CommandType
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class ReadFromFile : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        try {
            val fileName = singleArg!!
            val reader = BufferedReader(InputStreamReader(FileInputStream(fileName)))
            val pair = Pair(fileName, reader)
            if (scriptStack.contains(pair) && scriptStack.last().first != fileName) return false
            readerManager.set(reader)
            if (!scriptStack.contains(pair)) scriptStack.add(pair)
            return true
        } catch (_: Exception) {
            return false
        }
    }
}
