package views

import app.Style
import clientMessageHandler
import controllers.SetUserController
import javafx.geometry.Orientation
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ProgressIndicator
import javafx.util.Duration
import models.User
import models.UserModel
import tornadofx.*
import tornadofx.ViewTransition.Slide

class AuthScreen(commandName: String, errorHint: String) : View() {
    override val root = Form().addClass(Style.form)
    private val model = UserModel(User())
    private val controller: SetUserController by inject()
    init {
        title = commandName

        with(root) {
            fieldset {
                labelPosition = Orientation.VERTICAL
                field("Username") {
                    textfield(model.username).required(message = "Insert your username")
                }
                field("Password") {
                    passwordfield(model.password).required(message = "Insert your password")
                }
            }
            buttonbar {
                button("Enter") {
                    action {
                        exec(commandName, errorHint)
                    }
                }
                button("Go back") {
                    action {
                        replaceWith(StartScreen::class, sizeToScene = true)
                    }
                }
            }
        }
    }

    private fun Button.exec(commandName: String, errorHint: String) {

        if(model.commit()) {
            graphic = ProgressIndicator()
            runAsync {
                controller.exec(commandName, model.user)
            } ui { (success, ans) ->
                if (success) {
                    clientMessageHandler.invoke(ans.second)
                    replaceWith(MainScreen::class, Slide(Duration(100.0)), sizeToScene = true)
                }
                else {
                    val header = if (ans.first) errorHint
                    else "Server is dead"
                    alert(Alert.AlertType.WARNING,"$commandName failed", header)
                }
            }
        }
    }
}
