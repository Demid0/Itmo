package models

import builders.route
import javafx.beans.property.SimpleStringProperty
import tornadofx.ValidationContext
import tornadofx.ValidationMessage
import tornadofx.ValidationSeverity
import tornadofx.ViewModel

class Args  {
    val properties = ArrayList<SimpleStringProperty>(15)
    init {
        for (n in 1..15) {
            properties.add(SimpleStringProperty(""))
        }
    }
}

class ArgsModel(args: Args): ViewModel() {
    fun createRoute() = route {
        name = route_name.value
        coordinates = coordinates {
            x = coordinates_x.value.toFloatOrNull()
            y = coordinates_y.value.toIntOrNull()
        }
        from = location {
            x = from_x.value.toIntOrNull()
            y = from_y.value.toFloat()
            z = from_z.value.toLong()
            name = from_name.value
        }
        to = location {
            x = to_x.value.toIntOrNull()
            y = to_y.value.toFloat()
            z = to_z.value.toLong()
            name = to_name.value
        }
        distance = route_distance.value.toDouble()
    }

    val route_id = bind {  args.properties[0] }
    val route_name = bind {  args.properties[1] }
    val coordinates_x = bind {  args.properties[2] }
    val coordinates_y = bind {  args.properties[3] }
    val from_x = bind {  args.properties[4] }
    val from_y = bind {  args.properties[5] }
    val from_z = bind {  args.properties[6] }
    val from_name = bind {  args.properties[7] }
    val to_x = bind {  args.properties[8] }
    val to_y = bind {  args.properties[9] }
    val to_z = bind {  args.properties[10] }
    val to_name = bind {  args.properties[11] }
    val route_distance = bind { args.properties[12] }
    val string_arg = bind { args.properties[13] }

    val route_id_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
        input ->
        if (try {
            val x = input?.toDouble()
                x != null && x > 0
            } catch (_: Exception) { false }
            ) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be Double and more than 0", ValidationSeverity.Error)
    }
    val route_name_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
        input -> if (input != "" && input != null) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be String with more than 0 length", ValidationSeverity.Error)
    }
    val coordinates_x_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
        input ->
        val x = input?.toFloatOrNull()
        if (x == null || x <= 800) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be null or Float less than 800", ValidationSeverity.Error)
    }
    val coordinates_y_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
        input ->
        if (
            try {
                input?.toIntOrNull()
                true
            } catch(_: Exception) {
                false
            }) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be null or Int", ValidationSeverity.Error)
    }
    val location_x_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
            input ->
        if (
            try {
                input?.toIntOrNull()
                true
            } catch(_: Exception) {
                false
            }) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be null or Int", ValidationSeverity.Error)
    }
    val location_y_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
            input ->
        if (
            try {
                input!!.toFloat()
                true
            } catch(_: Exception) {
                false
            }) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be Float", ValidationSeverity.Error)
    }
    val location_z_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
            input ->
        if (
            try {
                input!!.toLong()
                true
            } catch(_: Exception) {
                false
            }) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be Long", ValidationSeverity.Error)
    }
    val location_name_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
            input ->
        if (input != "" && input != null && input.length <= 496) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be null or String with length in values (1, 496)", ValidationSeverity.Error)
    }
    val distance_valid: ValidationContext.(input: String?) -> ValidationMessage? = {
            input ->
        if (
            try {
                val x = input!!.toDouble()
                x > 1
            } catch(_: Exception) {
                false
            }) ValidationMessage("", ValidationSeverity.Success)
        else ValidationMessage("this field must be Double and more than 1", ValidationSeverity.Error)
    }
}
