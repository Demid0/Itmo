package Utils

import CollectionObjectsClasses.Route
import Commands.*
import Serialization.*
import Serialization.Strategies.*
import java.io.*
import kotlin.system.exitProcess

class Starter {
    fun start(tank: Tank) {
        //all functional
        downloadCommands(tank.invoker)
        downloadSerializationStrategies(tank.serializator)
        downloadSupportedCollectionTypes(tank.data)

        //last functional condition
        downloadLastSystemCondition(tank)

        //saved data
        downloadCollection(tank.data, tank.serializator)
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
        invoker.addCommand("exit", Exit()) // done
        invoker.addCommand("help", Help()) // done
        invoker.addCommand("info", Info()) // done
        invoker.addCommand("show", Show()) // done
        invoker.addCommand("add", Add()) // optimize validator
        invoker.addCommand("update", UpdateId()) // done
        invoker.addCommand("remove_by_id", RemoveById()) // done
        invoker.addCommand("clear", Clear()) // done
        invoker.addCommand("save", Save()) // done
        invoker.addCommand("execute_script", ExecuteScript()) // change with writer and printer, StackOverflowError, executes path
        invoker.addCommand("remove_first", RemoveFirst()) // done
        invoker.addCommand("add_if_max", AddIfMax()) // done
        invoker.addCommand("remove_lower", RemoveLower()) // done
        invoker.addCommand("count_by_distance", CountDistance { a: Double, b: Double -> a == b }) // done
        invoker.addCommand("count_less_than_distance", CountDistance { a: Double, b: Double -> a < b }) // done
        invoker.addCommand("print_field_descending_distance", PrintFieldDescendingDistance()) // done
        invoker.addCommand("change_collection_type", ChangeCollectionType()) // done
        invoker.addCommand("change_serialization_strategy", ChangeSerializationStrategy()) // done
        println("Done!")
    }
    fun downloadSerializationStrategies(serializator: Serializator) {
        println("Downloading supported serialization strategy")
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
            tank.serializator.changeStrategy(tank.serializator.getStrategy(output[1])!!)
            println("Done!")
        } catch (e: Exception) {
            println("Can't found info about last system condition. Will use default serialization strategy and default collection type.")
        }
    }

}