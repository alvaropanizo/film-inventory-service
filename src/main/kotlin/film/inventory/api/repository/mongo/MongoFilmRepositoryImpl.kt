package film.inventory.api.repository.mongo

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import film.inventory.api.config.InventoryServiceConfig
import film.inventory.api.model.RentalFilm
import film.inventory.api.repository.FilmRepository
import film.inventory.api.repository.mapper.MongoRentalFilmMapper
import org.bson.BsonDocument
import org.bson.BsonString
import org.bson.Document

class MongoFilmRepositoryImpl(private val mongoClient: MongoClient,
                              private val inventoryServiceConfig: InventoryServiceConfig,
                              private val mongoRentalFilmMapper: MongoRentalFilmMapper) : FilmRepository<RentalFilm> {

    companion object {
        const val ID = "id"
    }

    override fun findOne(id: Long?): RentalFilm {
        return mongoRentalFilmMapper.toRentalFilm(getCollection()
                .find(BsonDocument(ID, BsonString(id.toString()))).first())
    }

    override fun save(film: RentalFilm): RentalFilm {
        getCollection().insertOne(mongoRentalFilmMapper.toSource(film))
        return film
    }

    override fun delete(id: Long?): Int {
        return getCollection().deleteOne(BsonDocument(ID, BsonString(id.toString()))).deletedCount.toInt()
    }

    override fun findAll(): Iterable<RentalFilm> {
        return mongoRentalFilmMapper.toRentalFilm(getCollection().find())
    }

    override fun update(id: Long?, film: RentalFilm): RentalFilm {
        return mongoRentalFilmMapper.toRentalFilm(
                getCollection().find(BsonDocument(ID, BsonString(id.toString()))).first())
    }

    fun getCollection(): MongoCollection<Document> {
        return mongoClient
                .getDatabase(inventoryServiceConfig.databaseName)
                .getCollection(inventoryServiceConfig.databaseCollection)
    }
}