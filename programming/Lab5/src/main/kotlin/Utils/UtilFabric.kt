package Utils

import Commands.*
import Serialization.Serializator
import Serialization.Strategies.JsonStrategy

class UtilFabric {

    fun createStarter() = Starter()

    fun createAsker() = Asker()

    fun createInvoker() : Invoker {
        val invoker = Invoker()
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
        return invoker
    }

    fun createSerializator() : Serializator {
        val serializator = Serializator()
        serializator.addStrategy("jsonstrategy", JsonStrategy())
        return serializator
    }

    fun createData() : Data {
        val data = Data()
        data.addSupportedCollectionType("arraylist", ArrayList())
        data.addSupportedCollectionType("arraydeque", ArrayDeque())
        return data
    }

}