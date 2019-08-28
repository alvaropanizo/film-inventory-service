package film.inventory.api.service

import film.inventory.api.model.RentalFilm
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class InventoryService {

    fun getFilm(id: String): Single<RentalFilm> {
        return Single.just(RentalFilm(id, "filmId", "Planet of the Apes"))
    }

    fun getAllFilms(): Single<List<RentalFilm>> {
        return Single.just(listOf(RentalFilm("1", "PLA01", "Planet of the Apes"), RentalFilm("2", "PLA01", "Planet of the Apes")))
    }

    fun saveAndUpdateFilm(film: RentalFilm): Single<RentalFilm> {
        return Single.just(film)
    }
}