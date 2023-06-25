package views

import app.MyApp
import app.MyApp.Companion.usernameProperty
import app.Style
import commandArgumentsAndTheirsComponents.Route
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.CacheHint
import javafx.scene.control.TabPane
import javafx.scene.text.FontWeight
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.inject
import tornadofx.*
import utils.ParseCommandAndAskArguments
import java.util.*

class MainScreen : View(MyApp.getString("main")), KoinComponent {
    companion object {
        val parseCommandAndAskArguments: ParseCommandAndAskArguments by inject(ParseCommandAndAskArguments::class.java)
        val outputProperty = SimpleStringProperty()
        val collection: ObservableList<Route> = mutableListOf<Route>().asObservable()
    }
    override val root = TabPane().addClass(Style.main)

    init {
        with(root) {
            tab(MyApp.getString("collection")) {
                hbox {
                    primaryStage.isResizable = true
                    vbox{
                        scrollpane{
                            minWidth = 1100.0
                            minHeight = 600.0
                            tableview(collection) {
                                minWidth = 1200.0
                                minHeight = 600.0
                                column(MyApp.getString("route","name"), Route::getName)
                                column(MyApp.getString("coordinates","x"), Route::getCoordinates).cellFormat { text = it.getX().toString() }
                                column(MyApp.getString("coordinates","y"), Route::getCoordinates).cellFormat { text = it.getY().toString() }
                                column(MyApp.getString("from","x"), Route::getFrom).cellFormat { text = it?.getX().toString() }
                                column(MyApp.getString("from","y"), Route::getFrom).cellFormat { text = it?.getY().toString() }
                                column(MyApp.getString("from","z"), Route::getFrom).cellFormat { text = it?.getZ().toString() }
                                column(MyApp.getString("from","name"), Route::getFrom).cellFormat { text = it?.getName().toString() }
                                column(MyApp.getString("to","x"), Route::getTo).cellFormat { text = it.getX().toString() }
                                column(MyApp.getString("to","y"), Route::getTo).cellFormat { text = it.getY().toString() }
                                column(MyApp.getString("to","z"), Route::getTo).cellFormat { text = it.getZ().toString() }
                                column(MyApp.getString("to","name"), Route::getTo).cellFormat { text = it.getName() }
                                column(MyApp.getString("route","distance"), Route::getDistance)
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
                        maxWidth = 400.0
                        style {
                            padding = box(10.px)
                        }
                        hbox {
                            label(MyApp.getString("username") + ": ") {
                                style {
                                    fontSize = 20.px
                                    fontWeight = FontWeight.BOLD
                                }
                            }
                            text {
                                style {
                                    fontSize = 20.px
                                    fontWeight = FontWeight.BOLD
                                    padding = box(10.px)
                                }
                                textProperty().bindBidirectional(usernameProperty)
                            }
                        }
                        form {
                            style {
                                padding = box(20.px)
                            }
                            initCommandButtons.invoke(this, this@MainScreen)
                        }
                        hbox(10, Pos.BOTTOM_RIGHT) {
                            button {
                                action {
                                    hbox {
                                        val toggle = togglegroup {
                                            togglebutton("Russian") {
                                                action {
                                                    MyApp.bundle = ResourceBundle.getBundle("messages", Locale("ru"))
                                                    this@MainScreen.replaceWith(MainScreen())
                                                }
                                            }
                                            togglebutton("English") {
                                                action {
                                                    MyApp.bundle = ResourceBundle.getBundle("messages", Locale("en"))
                                                    this@MainScreen.replaceWith(MainScreen())
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                    onRefresh()
                }
            }
        }
    }
}

val initCommandButtons: Form.(v: View)-> Unit = {
    MainScreen.parseCommandAndAskArguments.getCommands().map { command ->
        button(MyApp.getString(command.key)) {
            style {
                padding = box(10.px)
                prefWidth = 240.px
            }
            action {
                if (command.key == "logout") it.replaceWith(StartScreen(), sizeToScene = true)
                AskArgsScreen(command.key, command.value).op.invoke(this, it)
            }
            onMouseEntered = EventHandler {
                style {
                    padding = box(15.px)
                    prefWidth = 260.px
                }
                this.cacheHint = CacheHint.ROTATE
            }
            onMouseExited = EventHandler {
                style {
                    padding = box(10.px)
                    prefWidth = 240.px
                }
            }
        }
    }
}