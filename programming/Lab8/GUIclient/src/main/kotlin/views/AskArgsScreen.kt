package views

import app.Style
import builders.packet
import clientMessageHandler
import commandArgumentsAndTheirsComponents.CommandType
import javafx.geometry.Orientation
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ScrollPane
import javafx.util.Duration
import models.Args
import models.ArgsModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tornadofx.*
import utils.SystemCommandInvoker
import java.lang.Thread.sleep

class AskArgsScreen(commandName: String, commandType: CommandType): View(commandName), KoinComponent {
    private val systemCommandInvoker by inject<SystemCommandInvoker>()
    private val model = ArgsModel(Args())
    override val root = ScrollPane().addClass(Style.form)
    private val singleArgHints = hashMapOf(
        "count_by_distance" to "distance",
        "count_less_than_distance" to "distance",
        "execute_script" to "file name",
        "remove_by_id" to "id"
    )
    val op: Button.(v: View) -> Any = when (commandType) {
        CommandType.NO_ARG -> {
            {
                clientMessageHandler.run(packet {
                    this.commandName = commandName
                })
            }
        }
        CommandType.SINGLE_ARG -> {
            {
                it.replaceWith(this@AskArgsScreen, ViewTransition.Slide(Duration(300.0)), sizeToScene = true)
                with(this@AskArgsScreen.root) {
                    form {
                        fieldset {
                            labelPosition = Orientation.VERTICAL
                            field(singleArgHints[commandName] ?: "") {
                                textfield(model.string_arg).required()
                            }
                        }
                        buttonbar {
                            button("Enter") {
                                action {
                                    if (model.commit()) {
                                        clientMessageHandler.run(packet {
                                            this.commandName = commandName
                                            string(model.string_arg.value)
                                        })
                                        if (commandName == "execute_script") sleep(500)
                                        this@AskArgsScreen.replaceWith(
                                            MainScreen::class,
                                            ViewTransition.Slide(Duration(300.0)),
                                            sizeToScene = true
                                        )
                                    }
                                }
                            }
                            button("Go Back") {
                                action {
                                    this@AskArgsScreen.replaceWith(
                                        MainScreen::class,
                                        ViewTransition.Slide(Duration(300.0)),
                                        sizeToScene = true
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        CommandType.OBJECT_ARG -> {
            {
                it.replaceWith(this@AskArgsScreen, ViewTransition.Slide(Duration(300.0)), sizeToScene = true)
                with(this@AskArgsScreen.root) {
                    form {
                        fieldset("Route") {
                            labelPosition = Orientation.VERTICAL
                            field("Name") {
                                textfield(model.route_name).validator(
                                    ValidationTrigger.OnChange(),
                                    model.route_name_valid
                                )
                            }
                            fieldset("Coordinates") {
                                labelPosition = Orientation.VERTICAL
                                field("X") {
                                    textfield(model.coordinates_x).validator(
                                        ValidationTrigger.OnChange(),
                                        model.coordinates_x_valid
                                    )
                                }
                                field("Y") {
                                    textfield(model.coordinates_y).validator(
                                        ValidationTrigger.OnChange(),
                                        model.coordinates_y_valid
                                    )
                                }
                            }
                            fieldset("From") {
                                labelPosition = Orientation.VERTICAL
                                field("X") {
                                    textfield(model.from_x).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_x_valid
                                    )
                                }
                                field("Y") {
                                    textfield(model.from_y).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_y_valid
                                    )
                                }
                                field("Z") {
                                    textfield(model.from_z).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_z_valid
                                    )
                                }
                                field("Name") {
                                    textfield(model.from_name).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_name_valid
                                    )
                                }
                            }
                            fieldset("To") {
                                labelPosition = Orientation.VERTICAL
                                field("X") {
                                    textfield(model.to_x).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_x_valid
                                    )
                                }
                                field("Y") {
                                    textfield(model.to_y).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_y_valid
                                    )
                                }
                                field("Z") {
                                    textfield(model.to_z).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_z_valid
                                    )
                                }
                                field("Name") {
                                    textfield(model.to_name).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_name_valid
                                    )
                                }
                            }
                            field("Distance") {
                                textfield(model.route_distance).validator(
                                    ValidationTrigger.OnChange(),
                                    model.distance_valid
                                )
                            }
                        }
                        buttonbar {
                            button("Enter") {
                                action {
                                    if (model.commit()) {
                                        clientMessageHandler.run(packet {
                                            this.commandName = commandName
                                            route(model.createRoute())
                                        })
                                        this@AskArgsScreen.replaceWith(
                                            MainScreen::class,
                                            ViewTransition.Slide(Duration(300.0)),
                                            sizeToScene = true
                                        )
                                    } else {
                                        alert(Alert.AlertType.WARNING, "Wrong args type", "Check your input")
                                    }
                                }
                            }
                            button("Go Back") {
                                action {
                                    this@AskArgsScreen.replaceWith(
                                        MainScreen::class,
                                        ViewTransition.Slide(Duration(300.0)),
                                        sizeToScene = true
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        CommandType.MIXED_ARG -> {
            {
                it.replaceWith(this@AskArgsScreen, ViewTransition.Slide(Duration(300.0)), sizeToScene = true)
                with(this@AskArgsScreen.root) {
                    form {
                        fieldset {
                            labelPosition = Orientation.VERTICAL
                            field("Id") {
                                textfield(model.route_id).validator(ValidationTrigger.OnChange(), model.route_id_valid)
                            }
                            fieldset("Route") {
                                labelPosition = Orientation.VERTICAL
                                field("Name") {
                                    textfield(model.route_name).validator(
                                        ValidationTrigger.OnChange(),
                                        model.route_name_valid
                                    )
                                }
                                fieldset("Coordinates") {
                                    labelPosition = Orientation.VERTICAL
                                    field("X") {
                                        textfield(model.coordinates_x).validator(
                                            ValidationTrigger.OnChange(),
                                            model.coordinates_x_valid
                                        )
                                    }
                                    field("Y") {
                                        textfield(model.coordinates_y).validator(
                                            ValidationTrigger.OnChange(),
                                            model.coordinates_y_valid
                                        )
                                    }
                                }
                                fieldset("From") {
                                    labelPosition = Orientation.VERTICAL
                                    field("X") {
                                        textfield(model.from_x).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_x_valid
                                        )
                                    }
                                    field("Y") {
                                        textfield(model.from_y).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_y_valid
                                        )
                                    }
                                    field("Z") {
                                        textfield(model.from_z).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_z_valid
                                        )
                                    }
                                    field("Name") {
                                        textfield(model.from_name).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_name_valid
                                        )
                                    }
                                }
                                fieldset("To") {
                                    labelPosition = Orientation.VERTICAL
                                    field("X") {
                                        textfield(model.to_x).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_x_valid
                                        )
                                    }
                                    field("Y") {
                                        textfield(model.to_y).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_y_valid
                                        )
                                    }
                                    field("Z") {
                                        textfield(model.to_z).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_z_valid
                                        )
                                    }
                                    field("Name") {
                                        textfield(model.to_name).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_name_valid
                                        )
                                    }
                                }
                                field("Distance") {
                                    textfield(model.route_distance).validator(
                                        ValidationTrigger.OnChange(),
                                        model.distance_valid
                                    )
                                }
                            }
                        }
                        buttonbar {
                            button("Enter") {
                                action {
                                    if (model.commit()) {
                                        clientMessageHandler.run(packet {
                                            this.commandName = commandName
                                            string(model.route_id.value)
                                            route(model.createRoute())
                                        })
                                        this@AskArgsScreen.replaceWith(
                                            MainScreen::class,
                                            ViewTransition.Slide(Duration(300.0)),
                                            sizeToScene = true
                                        )
                                    } else {
                                        alert(Alert.AlertType.WARNING, "Wrong args type", "Check your input")
                                    }
                                }
                            }
                            button("Go Back") {
                                action {
                                    this@AskArgsScreen.replaceWith(
                                        MainScreen::class,
                                        ViewTransition.Slide(Duration(300.0)),
                                        sizeToScene = true
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        CommandType.VISIBILITY_ARG -> {
            {
                clientMessageHandler.run(packet {
                    this.commandName = commandName
                    visibility(clientMessageHandler.condition.get())
                })
            }
        }
        CommandType.EXECUTE_LOCALLY -> {
            {
                systemCommandInvoker.invoke(packet { this.commandName = commandName }.wrapIntoArray())
            }
        }
        else -> { {} }
    }
}
