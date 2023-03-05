import Commands.*

class Starter {
    companion object {
        fun start() {
            println("Hello, Nikita Alexeyevich")
            downloadCommands()
            downloadCollection()
        }
        private fun downloadCollection() {
            println("Downloading collection")
            // здесь будет загружаться коллекция с файла в Data.collection
            println("Done!")
        }
        private fun downloadCommands() {
            println("Downloading commands")
            Data.addCommand("exit", Exit())
            Data.addCommand("help", Help())
            Data.addCommand("info", Info())
            Data.addCommand("show", Show())
            Data.addCommand("add", Add())
            Data.addCommand("update", UpdateId())
            Data.addCommand("remove_by_id", RemoveById())
            Data.addCommand("clear", Clear())
            Data.addCommand("save", Save())
            Data.addCommand("execute_script", ExecuteScript())
            Data.addCommand("remove_first", RemoveFirst())
            Data.addCommand("add_if_max", AddIfMax())
            Data.addCommand("remove_lower", RemoveLower())
            Data.addCommand("count_by_distance", CountDistance { a: Double, b: Double -> a == b })
            Data.addCommand("count_less_than_distance", CountDistance { a: Double, b: Double -> a < b })
            Data.addCommand("print_field_descending_distance", PrintFieldDescendingDistance())
            println("Done!")
        }
    }
}