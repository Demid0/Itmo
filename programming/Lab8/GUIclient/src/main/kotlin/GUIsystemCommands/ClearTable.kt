package GUIsystemCommands

import systemCommands.SystemCommand
import views.MainScreen

val clearTable = SystemCommand("clear_table", {}) {
    MainScreen.collection.clear()
}