package Utils

import CollectionObjectsClasses.Route
import Commands.*
import Serialization.*
import Serialization.Strategies.*
import java.io.*
import kotlin.system.exitProcess

class Starter {
    fun start(tank: Tank) {
        downloadCollection(tank.data, tank.serializator)
        downloadCommands(tank.invoker)
        downloadSerializationStrategies(tank.serializator)
        downloadSupportedCollectionTypes(tank.data)

        downloadLastSystemCondition(tank)
    }
    fun downloadCollection(data: Data, serializator: Serializator) {
        println("Downloading collection")
        try {
            val file = File(data.getFileName())
            val reader = InputStreamReader(file.inputStream())
            val collection = ArrayDeque<Route>()
            for (str in reader.readLines()) {
                collection.add(serializator.deserialize(str))
            }
            data.collection = collection
        } catch (e: Exception) {
            println("File not found")
            exitProcess(1)
        }
        println("Done!")
    }
    fun downloadCommands(invoker: Invoker) {
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
        invoker.addCommand("change_serialization_strategy", ChangeSerializationStrategy())
        println("Done!")
    }
    fun downloadSerializationStrategies(serializator: Serializator) {
        println("Downloading supported serialization strategy")
        serializator.addStrategy("yamlstrategy", YamlStrategy())
        serializator.addStrategy("jsonstrategy", JsonStrategy())
        println("Done!")
    }
    fun downloadSupportedCollectionTypes(data: Data) {
        println("Downloading supported collection types")
        data.addSupportedCollectionType("arraylist", ArrayList())
        data.addSupportedCollectionType("arraydeque", ArrayDeque())
        println("Done!")
    }
    fun downloadLastSystemCondition(tank: Tank) {
        println("Downloading last system condition")
        try {
            val file = File(tank.data.getInfoFileName())
            val reader = InputStreamReader(file.inputStream())
            val output = reader.readLines()
            tank.data.changeType(output[0])
            tank.serializator.changeStrategy(tank.serializator.getStrategies(output[1])!!)
            println("Done!")
        } catch (e: Exception) {
            println("Can't found info about last system condition. Will use default serialization strategy and default collection type.")
        }
    }

}