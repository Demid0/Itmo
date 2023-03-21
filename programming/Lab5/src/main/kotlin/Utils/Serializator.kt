package Utils

import CollectionObjectsClasses.Route
import SerializationStrategies.JsonStrategy
import SerializationStrategies.Strategy
import SerializationStrategies.YamlStrategy

class Serializator {
    private var strategies: HashMap<String, Strategy> = hashMapOf()
    private var chosenStrategy: Strategy = JsonStrategy()

    init {
        addStrategy("jsonstrategy", JsonStrategy())
        addStrategy("yamlstrategy", YamlStrategy())
    }
    fun serialize(collection: MutableCollection<Route>) = chosenStrategy.encode(collection)
    fun deserialize(string: String) = chosenStrategy.decode(string)

    fun addStrategy(name: String, strategy: Strategy) {
        strategies[name] = strategy
    }

    fun getStrategy(name: String) = strategies[name]
    fun getStrategies() = strategies

    fun changeStrategy(strategy: Strategy) {
        chosenStrategy = strategy
    }

    fun getChosenStrategy() = chosenStrategy
}