package Utils

import CollectionObjectsClasses.Route

class Data {
    var collection: MutableCollection<Route> = ArrayDeque()
    private var supportedCollectionTypes: HashMap<String, MutableCollection<Route>> = hashMapOf()
    private var fileName = System.getenv("lab5_filename")
    private var infoFileName = System.getenv("lab5_collection_info_file")
    fun changeType(newType: String) {
        val old = collection
        collection = supportedCollectionTypes[newType.lowercase()]!!
        for (element in old) {
            collection.add(element)
        }
    }
    fun addSupportedCollectionType(name: String, collection: MutableCollection<Route>) {
        supportedCollectionTypes[name] = collection
    }
    fun getFileName() = fileName
    fun getInfoFileName() = infoFileName

}