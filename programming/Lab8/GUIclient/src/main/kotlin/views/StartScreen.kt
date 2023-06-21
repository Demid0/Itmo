package views

import app.Style
import tornadofx.*

class StartScreen : View("Start") {
    override val root = Form().addClass(Style.form)

    init {
        with(root) {
            buttonbar {
                button("login") {
                    action {
                        replaceWith(AuthScreen("login", "Wrong username or password"), sizeToScene = true)
                    }
                }
                button("sign_up") {
                    action {
                        replaceWith(AuthScreen("sign_up", "User with this name already exists"), sizeToScene = true)
                    }
                }
            }
        }
    }
}
