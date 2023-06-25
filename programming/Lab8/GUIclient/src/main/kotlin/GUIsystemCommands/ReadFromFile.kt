package GUIsystemCommands

import app.MyApp
import clientMessageHandler
import exceptions.RecursionException
import exceptions.SystemCommandInvocationException
import systemCommands.SystemCommand
import utils.argToString
import views.MainScreen
import java.io.*
import java.lang.NullPointerException

val readFromFile = SystemCommand("read_from_file", argToString) {
        argument ->
    try {
        var fileName = argument
        val file = File(fileName)
        val reader = BufferedReader(InputStreamReader(FileInputStream(file)))
        fileName = file.absolutePath
        if (scriptStack.contains(fileName)) throw RecursionException()
        readerManager.set(reader)
        if (!scriptStack.contains(fileName)) {
            scriptStack.add(fileName)
            readerStack[fileName] = reader
        }
        try {
            while (true) {
                clientMessageHandler.run(app.run(readerManager, writerManager)!!)
            }
        } catch (e: NullPointerException) {
            readerStack.clear()
            scriptStack.clear()
            app.setDefaultCondition(e)
            MainScreen.outputProperty.value = MyApp.getString("execution_successful")
        }
    } catch (e: SystemCommandInvocationException) {
        throw e
    } catch (_: FileNotFoundException) {
        MainScreen.outputProperty.value = MyApp.getString("file_not_found")
    } catch (_: Exception) {
        MainScreen.outputProperty.value = MyApp.getString("unknown_error")
    }
}
