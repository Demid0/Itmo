package views

import app.MyApp
import app.Style
import builders.packet
import clientMessageHandler
import commandArgumentsAndTheirsComponents.CommandType
import javafx.geometry.Orientation
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ScrollPane
import javafx.stage.Stage
import javafx.util.Duration
import models.Args
import models.ArgsModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tornadofx.*
import utils.SystemCommandInvoker
import java.lang.Thread.sleep

class AskArgsScreen(commandName: String, commandType: CommandType): View(MyApp.getString(commandName)), KoinComponent {
    private val systemCommandInvoker by inject<SystemCommandInvoker>()
    private val model = ArgsModel(Args())
    override val root = ScrollPane().addClass(Style.form)
    private val singleArgHints = hashMapOf(
        "count_by_distance" to MyApp.getString("distance"),
        "count_less_than_distance" to MyApp.getString("distance"),
        "execute_script" to MyApp.getString("file_name"),
        "remove_by_id" to MyApp.getString("id")
    )
    init {
        this.setWindowMinSize(350, 0)
    }
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
                it.replaceWith(this@AskArgsScreen, ViewTransition.Slide(Duration(200.0)), sizeToScene = true)
                with(this@AskArgsScreen.root) {
                    form {
                        fieldset {
                            labelPosition = Orientation.VERTICAL
                            field(singleArgHints[commandName] ?: "") {
                                textfield(model.string_arg).required(message = MyApp.getString("field_error"))
                            }
                        }
                        buttonbar {
                            button(MyApp.getString("enter_button")) {
                                action {
                                    if (model.commit()) {
                                        clientMessageHandler.run(packet {
                                            this.commandName = commandName
                                            string(model.string_arg.value)
                                        })
                                        this@AskArgsScreen.replaceWith(
                                            MainScreen(),
                                            ViewTransition.Slide(Duration(200.0)),
                                            sizeToScene = true
                                        )
                                    }
                                }
                            }
                            button(MyApp.getString("go_back_button")) {
                                action {
                                    this@AskArgsScreen.replaceWith(
                                        MainScreen(),
                                        ViewTransition.Slide(Duration(200.0)),
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
                it.replaceWith(this@AskArgsScreen, ViewTransition.Slide(Duration(200.0)), sizeToScene = true)
                with(this@AskArgsScreen.root) {
                    form {
                        fieldset(MyApp.getString("route")) {
                            labelPosition = Orientation.VERTICAL
                            field(MyApp.getString("name")) {
                                textfield(model.route_name).validator(
                                    ValidationTrigger.OnChange(),
                                    model.route_name_valid
                                )
                            }
                            fieldset(MyApp.getString("coordinates")) {
                                labelPosition = Orientation.VERTICAL
                                field(MyApp.getString("x")) {
                                    textfield(model.coordinates_x).validator(
                                        ValidationTrigger.OnChange(),
                                        model.coordinates_x_valid
                                    )
                                }
                                field(MyApp.getString("y")) {
                                    textfield(model.coordinates_y).validator(
                                        ValidationTrigger.OnChange(),
                                        model.coordinates_y_valid
                                    )
                                }
                            }
                            fieldset(MyApp.getString("from")) {
                                labelPosition = Orientation.VERTICAL
                                field(MyApp.getString("x")) {
                                    textfield(model.from_x).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_x_valid
                                    )
                                }
                                field(MyApp.getString("y")) {
                                    textfield(model.from_y).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_y_valid
                                    )
                                }
                                field(MyApp.getString("z")) {
                                    textfield(model.from_z).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_z_valid
                                    )
                                }
                                field(MyApp.getString("name")) {
                                    textfield(model.from_name).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_name_valid
                                    )
                                }
                            }
                            fieldset(MyApp.getString("to")) {
                                labelPosition = Orientation.VERTICAL
                                field(MyApp.getString("x")) {
                                    textfield(model.to_x).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_x_valid
                                    )
                                }
                                field(MyApp.getString("y")) {
                                    textfield(model.to_y).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_y_valid
                                    )
                                }
                                field(MyApp.getString("z")) {
                                    textfield(model.to_z).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_z_valid
                                    )
                                }
                                field(MyApp.getString("name")) {
                                    textfield(model.to_name).validator(
                                        ValidationTrigger.OnChange(),
                                        model.location_name_valid
                                    )
                                }
                            }
                            field(MyApp.getString("distance")) {
                                textfield(model.route_distance).validator(
                                    ValidationTrigger.OnChange(),
                                    model.distance_valid
                                )
                            }
                        }
                        buttonbar {
                            button(MyApp.getString("enter_button")) {
                                action {
                                    if (model.commit()) {
                                        clientMessageHandler.run(packet {
                                            this.commandName = commandName
                                            route(model.createRoute())
                                        })
                                        this@AskArgsScreen.replaceWith(
                                            MainScreen(),
                                            ViewTransition.Slide(Duration(200.0)),
                                            sizeToScene = true
                                        )
                                    } else {
                                        alert(Alert.AlertType.WARNING, MyApp.getString("wrong_arg_type"), MyApp.getString("check_your_input"))
                                    }
                                }
                            }
                            button(MyApp.getString("go_back_button")) {
                                action {
                                    this@AskArgsScreen.replaceWith(
                                        MainScreen(),
                                        ViewTransition.Slide(Duration(200.0)),
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
                it.replaceWith(this@AskArgsScreen, ViewTransition.Slide(Duration(200.0)), sizeToScene = true)
                with(this@AskArgsScreen.root) {
                    form {
                        fieldset {
                            labelPosition = Orientation.VERTICAL
                            field(MyApp.getString("id")) {
                                textfield(model.route_id).validator(ValidationTrigger.OnChange(), model.route_id_valid)
                            }
                            fieldset(MyApp.getString("route")) {
                                labelPosition = Orientation.VERTICAL
                                field(MyApp.getString("name")) {
                                    textfield(model.route_name).validator(
                                        ValidationTrigger.OnChange(),
                                        model.route_name_valid
                                    )
                                }
                                fieldset(MyApp.getString("coordinates")) {
                                    labelPosition = Orientation.VERTICAL
                                    field(MyApp.getString("x")) {
                                        textfield(model.coordinates_x).validator(
                                            ValidationTrigger.OnChange(),
                                            model.coordinates_x_valid
                                        )
                                    }
                                    field(MyApp.getString("y")) {
                                        textfield(model.coordinates_y).validator(
                                            ValidationTrigger.OnChange(),
                                            model.coordinates_y_valid
                                        )
                                    }
                                }
                                fieldset(MyApp.getString("from")) {
                                    labelPosition = Orientation.VERTICAL
                                    field(MyApp.getString("x")) {
                                        textfield(model.from_x).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_x_valid
                                        )
                                    }
                                    field(MyApp.getString("y")) {
                                        textfield(model.from_y).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_y_valid
                                        )
                                    }
                                    field(MyApp.getString("z")) {
                                        textfield(model.from_z).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_z_valid
                                        )
                                    }
                                    field(MyApp.getString("name")) {
                                        textfield(model.from_name).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_name_valid
                                        )
                                    }
                                }
                                fieldset(MyApp.getString("to")) {
                                    labelPosition = Orientation.VERTICAL
                                    field(MyApp.getString("x")) {
                                        textfield(model.to_x).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_x_valid
                                        )
                                    }
                                    field(MyApp.getString("y")) {
                                        textfield(model.to_y).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_y_valid
                                        )
                                    }
                                    field(MyApp.getString("z")) {
                                        textfield(model.to_z).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_z_valid
                                        )
                                    }
                                    field(MyApp.getString("name")) {
                                        textfield(model.to_name).validator(
                                            ValidationTrigger.OnChange(),
                                            model.location_name_valid
                                        )
                                    }
                                }
                                field(MyApp.getString("distance")) {
                                    textfield(model.route_distance).validator(
                                        ValidationTrigger.OnChange(),
                                        model.distance_valid
                                    )
                                }
                            }
                            buttonbar {
                                button(MyApp.getString("enter_button")) {
                                    action {
                                        if (model.commit()) {
                                            clientMessageHandler.run(packet {
                                                this.commandName = commandName
                                                route(model.createRoute())
                                            })
                                            this@AskArgsScreen.replaceWith(
                                                MainScreen(),
                                                ViewTransition.Slide(Duration(200.0)),
                                                sizeToScene = true
                                            )
                                        } else {
                                            alert(
                                                Alert.AlertType.WARNING,
                                                MyApp.getString("wrong_arg_type"),
                                                MyApp.getString("check_your_input")
                                            )
                                        }
                                    }
                                }
                                button(MyApp.getString("go_back_button")) {
                                    action {
                                        this@AskArgsScreen.replaceWith(
                                            MainScreen(),
                                            ViewTransition.Slide(Duration(200.0)),
                                            sizeToScene = true
                                        )
                                    }
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
