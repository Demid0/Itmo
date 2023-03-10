package Utils

import CollectionObjectsClasses.Route
import Commands.*
import Serialization.*
import Serialization.Strategies.*
import java.io.*

class Starter {
    fun start(tank: Tank) {
        downloadCollection(tank.data, tank.serializator)
        downloadCommands(tank.invoker)
        downloadSerializationStrategies(tank.serializator)
    }
    private fun downloadCollection(data: Data, serializator: Serializator) {
        println("Downloading collection")
        val file = File(System.getenv("lab5_filename"))
        val reader = InputStreamReader(file.inputStream())
        val collection = ArrayDeque<Route>()
        for (str in reader.readLines()) {
            collection.add(serializator.deserialize(str))
        }
        data.collection = collection
        println("Done!")
    }
    private fun downloadCommands(invoker: Invoker) {
        println("Downloading commands")
        invoker.addCommand("exit", Exit())
        invoker.addCommand("help", Help())
        invoker.addCommand("info", Info())
        invoker.addCommand("show", Show())
        invoker.addCommand("add", Add())
        invoker.addCommand("update", UpdateId())
        invoker.addCommand("remove_by_id", RemoveById())
        invoker.addCommand("clear", Clear())
        invoker.addCommand("save", Save())
        invoker.addCommand("execute_script", ExecuteScript())
        invoker.addCommand("remove_first", RemoveFirst())
        invoker.addCommand("add_if_max", AddIfMax())
        invoker.addCommand("remove_lower", RemoveLower())
        invoker.addCommand("count_by_distance", CountDistance { a: Double, b: Double -> a == b })
        invoker.addCommand("count_less_than_distance", CountDistance { a: Double, b: Double -> a < b })
        invoker.addCommand("print_field_descending_distance", PrintFieldDescendingDistance())
        invoker.addCommand("change_collection_type", ChangeCollectionType())
        println("Done!")
    }

    private fun downloadSerializationStrategies(serializator: Serializator) {
        serializator.addStrategy("yaml", YamlStrategy())
        serializator.addStrategy("json", JsonStrategy())
    }
}