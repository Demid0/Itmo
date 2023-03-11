package Serialization

import CollectionObjectsClasses.Route
import Serialization.Strategies.Strategy
import Serialization.Strategies.YamlStrategy

class Serializator {
    private var strategies = HashMap<String, Strategy>()
    private var chosenStrategy: Strategy = YamlStrategy()

    fun serialize(route: Route) = chosenStrategy.encode(route)
    fun deserialize(string: String) = chosenStrategy.decode(string)

    fun addStrategy(name: String, strategy: Strategy) {
        strategies[name] = strategy
    }

    fun getStrategies(name: String) = strategies[name]

    fun changeStrategy(strategy: Strategy) {
        chosenStrategy = strategy
    }

    fun getChosenStrategy() = chosenStrategy
}