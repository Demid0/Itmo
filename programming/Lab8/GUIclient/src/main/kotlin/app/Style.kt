package app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Style: Stylesheet() {
    companion object {
        val form by cssclass()
        val main by cssclass()
        val startWidth  = 300.px
    }

    init {
        form {
            padding = box(10.px)
            fontSize = 15.px
            fontWeight = FontWeight.BOLD
            prefWidth = startWidth
            buttonBar {
                button { prefWidth = startWidth }
            }
        }
        main {
            padding = box(10.px)
            fontSize = 15.px
            fontWeight = FontWeight.BOLD
            prefWidth = 1500.px
            prefHeight = 1500.px
            tabPane {
                tab {
                    fontSize = 10.px
                    fontWeight = FontWeight.BOLD

                }
            }
        }
    }
}
