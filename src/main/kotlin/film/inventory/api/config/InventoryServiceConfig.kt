package film.inventory.api.config

import io.micronaut.context.annotation.Value

class InventoryServiceConfig {

    @Value("\${database.name}")
    lateinit var databaseName: String

    @Value("\${database.collection}")
    lateinit var databaseCollection: String
}