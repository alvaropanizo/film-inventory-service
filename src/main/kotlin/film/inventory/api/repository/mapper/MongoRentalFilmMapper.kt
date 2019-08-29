package film.inventory.api.repository.mapper

import film.inventory.api.model.RentalFilm
import org.bson.Document

class MongoRentalFilmMapper : RentalFilmMapper<Document?> {

    override fun toRentalFilm(source: Iterable<Document?>): List<RentalFilm> {
        return ArrayList()
    }

    override fun toRentalFilm(source: Document?): RentalFilm {
        return RentalFilm(1, "", "")
    }

    override fun toSource(source: RentalFilm): Document? {
        return Document()
    }

    override fun toSource(source: List<RentalFilm>): List<Document?> {
        return listOf(Document())
    }
}