package GUIsystemCommands

import app.MyApp
import systemCommands.SystemCommand
import utils.argToString
import views.MainScreen

val printToClient = SystemCommand("print_to_client", argToString) {
    string ->
    var ans = ""
    string.split("\n").map{ ans += try { MyApp.getString(it) } catch (_: Exception) { it } + "\n" }
    MainScreen.outputProperty.set(ans)
}