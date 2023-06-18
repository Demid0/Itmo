package tornado

import commandArgumentsAndTheirsComponents.Visibility
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.Scene
import javafx.scene.text.Text
import javafx.stage.Stage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tornadofx.App
import utils.Condition


class MyApp : App(), KoinComponent {
    private val condition by inject<Condition>()
    private val stage = Stage()
    companion object {
        var visibilityProperty = SimpleObjectProperty<Visibility>()
        var currentPage = StartPage()
    }

    init {
        stage.height = 300.0
        stage.width = 300.0
        currentPage.properties["outputPanel"] = Text()
        currentPage.root.children.addAll(currentPage.properties["outputPanel"] as Text)
        visibilityProperty.bind(condition.get())
        visibilityProperty.addListener { observable, oldValue, newValue ->
            if (oldValue == Visibility.UNLOGGED_USER && newValue == Visibility.LOGGED_USER) ->
        }
    }

    override fun start(stage: Stage) {
        this.stage.scene = Scene(currentPage.root)
        this.stage.show()
    }

    override fun stop() {
        stage.close()
    }
}
