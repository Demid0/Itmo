package systemCommands

import exceptions.SystemCommandInvocationException
import exceptions.UIException
import javafx.scene.text.Text
import tornado.MyApp
import utils.argToString

val printToClient = SystemCommand("print_to_client", argToString) {
        singleArg ->
    try {
        val writer = writerManager.get()
        writer.print(singleArg)
        writer.flush()
        try {
            (MyApp.currentPage.properties["outputPanel"] as Text).text = singleArg
        } catch (e: Exception) {
            throw UIException(e.message ?: "")
        }
    } catch (e: Exception) {
        throw SystemCommandInvocationException("${e::class} : ${e.message}")
    }
}
