package systemCommands

import exceptions.RecursionException
import exceptions.SystemCommandInvocationException
import utils.CommandType
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStreamReader

class ReadFromFile : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?) {
        try {
            var fileName = singleArg!!
            val file = File(fileName)
            val reader = BufferedReader(InputStreamReader(FileInputStream(file)))
            fileName = file.absolutePath
            if (scriptStack.contains(fileName)) throw RecursionException()
            readerManager.set(reader)
            if (!scriptStack.contains(fileName)) {
                scriptStack.addLast(fileName)
                readerStack[fileName] = reader
            }
        } catch (e: SystemCommandInvocationException) {
            throw e
        } catch (_: FileNotFoundException) {
            throw SystemCommandInvocationException("File not found")
        } catch (_: Exception) {
            throw SystemCommandInvocationException()
        }
    }
}
