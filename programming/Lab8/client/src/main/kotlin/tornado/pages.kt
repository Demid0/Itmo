package tornado

import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import tornadofx.*

open class Page(pageName: String, pane: Pane, init: Pane.() -> Unit) : View(pageName) {
    override val root = pane.apply(init)
}

class StartPage : Page("Authentification", VBox(), {
    commandsButtonsInit.invoke()
    children.add(exitButton.create())
    children.addAll(commandsButtons.values.filter { it.commandName != "exit" })
})

class MainPage : Page("Main", VBox(), {
    commandsButtonsInit.invoke()
    children.add(exitButton.create())
    children.addAll(commandsButtons.values.filter { it.commandName != "exit" })
})
