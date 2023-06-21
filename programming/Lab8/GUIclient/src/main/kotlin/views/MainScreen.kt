package views


import app.Style
import commandArgumentsAndTheirsComponents.Route
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.control.TabPane
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.inject
import tornadofx.*
import utils.ParseCommandAndAskArguments

class MainScreen : View("Main"), KoinComponent {
    companion object {
        val parseCommandAndAskArguments: ParseCommandAndAskArguments by inject(ParseCommandAndAskArguments::class.java)
        val outputProperty = SimpleStringProperty()
        val collection: ObservableList<Route> = mutableListOf<Route>().asObservable()
    }
    override val root = TabPane().addClass(Style.main)

    init {
        with(root) {
            tab("Collection") {
                hbox {
                    primaryStage.isResizable = true
                    vbox{
                        scrollpane{
                            tableview(collection) {
                                column("Route - name", Route::getName)
                                column("Coordinates - x", Route::getCoordinates).cellFormat { text = it.getX().toString() }
                                column("Coordinates - y", Route::getCoordinates).cellFormat { text = it.getY().toString() }
                                column("From - x", Route::getFrom).cellFormat { text = it?.getX().toString() }
                                column("From - y", Route::getFrom).cellFormat { text = it?.getY().toString() }
                                column("From - z", Route::getFrom).cellFormat { text = it?.getZ().toString() }
                                column("From - name", Route::getFrom).cellFormat { text = it?.getName().toString() }
                                column("To - x", Route::getTo).cellFormat { text = it.getX().toString() }
                                column("To - y", Route::getTo).cellFormat { text = it.getY().toString() }
                                column("To - z", Route::getTo).cellFormat { text = it.getZ().toString() }
                                column("To - name", Route::getTo).cellFormat { text = it.getName() }
                                column("Route - distance", Route::getDistance)
                            }
                        }
                        scrollpane {
                            maxHeight = 400.0
                            text {
                                this.textProperty().bindBidirectional(outputProperty)
                            }
                        }
                    }
                    vbox {
                        form {
                            layoutX = this.scaleX / 2
                            layoutY = this.scaleY / 2
                            initCommandButtons.invoke(this, this@MainScreen)
                        }
                    }
                    onRefresh()
                }
            }
        }
    }
}

val initCommandButtons: Form.(v: View)-> Unit = {
    for (command in MainScreen.parseCommandAndAskArguments.getCommands()) {
        button(command.key) {
            action {
                if (command.key == "logout") it.replaceWith(StartScreen::class, sizeToScene = true)
                AskArgsScreen(command.key, command.value).op.invoke(this, it)
            }
        }
    }
}