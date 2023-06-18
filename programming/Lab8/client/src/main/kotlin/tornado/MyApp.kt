package tornado

import javafx.scene.Scene
import javafx.scene.text.Text
import javafx.stage.Stage
import org.koin.core.component.KoinComponent
import tornadofx.App


class MyApp : App(), KoinComponent {
    private val stage = Stage()
    companion object {
        var currentPage = StartPage()
    }

    init {
        stage.height = 300.0
        stage.width = 300.0
        currentPage.properties["outputPanel"] = Text()
        currentPage.root.children.addAll(currentPage.properties["outputPanel"] as Text)

    }

    override fun start(stage: Stage) {
        this.stage.scene = Scene(currentPage.root)
        this.stage.show()
    }

    override fun stop() {
        stage.close()
    }
}
