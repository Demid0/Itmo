package views

import app.MyApp
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
        with(root) {
            fieldset {
                labelPosition = Orientation.VERTICAL
                field(MyApp.getString("username")) {
                    textfield(model.username).required(message = MyApp.getString("username_required"))
                }
                field(MyApp.getString("password")) {
                    passwordfield(model.password).required(message = MyApp.getString("password_required"))
                }
            }
            buttonbar {
                button(MyApp.getString("enter_button")) {
                    action {
                        exec(commandName, errorHint)
                    }
                }
                button(MyApp.getString("go_back_button")) {
                    action {
                        replaceWith(StartScreen(), sizeToScene = true)
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
                    MyApp.usernameProperty.value = model.username.value
                    replaceWith(MainScreen(), Slide(Duration(100.0)), sizeToScene = true)
                }
                else {
                    val header = if (ans.first) errorHint
                    else MyApp.getString("server_dead_error")
                    alert(Alert.AlertType.WARNING,MyApp.getString("auth_failed"), header)
                }
            }
        }
    }
}
