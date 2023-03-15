package Serialization

import CollectionObjectsClasses.Route
import Serialization.Strategies.JsonStrategy
import Serialization.Strategies.Strategy

class Serializator {
    private var strategies = HashMap<String, Strategy>()
    private var chosenStrategy: Strategy = JsonStrategy()

    fun serialize(route: Route) = chosenStrategy.encode(route)
    fun deserialize(string: String) = chosenStrategy.decode(string)

    fun addStrategy(name: String, strategy: Strategy) {
        strategies[name] = strategy
    }

    fun getStrategy(name: String) = strategies[name]

    fun changeStrategy(strategy: Strategy) {
        chosenStrategy = strategy
    }

    fun getChosenStrategy() = chosenStrategy
}