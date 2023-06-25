package views

import app.MyApp
import app.Style
import tornadofx.*

class StartScreen : View(MyApp.getString("start")) {
    override val root = Form().addClass(Style.form)

    init {
        setWindowMinSize(400, 0)
        setWindowMaxSize(400, 0)
        with(root) {
            buttonbar {
                button(MyApp.getString("login")) {
                    action {
                        replaceWith(AuthScreen("login", MyApp.getString("login_error_hint")), sizeToScene = true)
                    }
                }
                button(MyApp.getString("sign_up")) {
                    action {
                        replaceWith(AuthScreen("sign_up", MyApp.getString("sign_up_error_hint")), sizeToScene = true)
                    }
                }
            }
        }
    }
}
