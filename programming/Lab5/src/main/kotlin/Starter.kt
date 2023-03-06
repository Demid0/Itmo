import Commands.*

class Starter {
    fun start(data: Data) {
        println("Hello, Nikita Alexeyevich")
        downloadCommands(data)
        downloadCollection(data)
    }
    private fun downloadCollection(data: Data) {
        println("Downloading collection")
        // здесь будет загружаться коллекция с файла в Data.collection
        println("Done!")
    }
    private fun downloadCommands(data: Data) {
        println("Downloading commands")
        data.addCommand("exit", Exit())
        data.addCommand("help", Help())
        data.addCommand("info", Info())
        data.addCommand("show", Show())
        data.addCommand("add", Add())
        data.addCommand("update", UpdateId())
        data.addCommand("remove_by_id", RemoveById())
        data.addCommand("clear", Clear())
        data.addCommand("save", Save())
        data.addCommand("execute_script", ExecuteScript())
        data.addCommand("remove_first", RemoveFirst())
        data.addCommand("add_if_max", AddIfMax())
        data.addCommand("remove_lower", RemoveLower())
        data.addCommand("count_by_distance", CountDistance { a: Double, b: Double -> a == b })
        data.addCommand("count_less_than_distance", CountDistance { a: Double, b: Double -> a < b })
        data.addCommand("print_field_descending_distance", PrintFieldDescendingDistance())
        println("Done!")
    }
}