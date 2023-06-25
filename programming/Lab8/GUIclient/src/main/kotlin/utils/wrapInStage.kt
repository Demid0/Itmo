package utils
import javafx.scene.Scene
import javafx.stage.Stage
import tornadofx.View

fun wrapInStage(view: View): Stage {
    val stage = Stage()
    val scene = Scene(view.root)
    stage.scene = scene
    return stage
}