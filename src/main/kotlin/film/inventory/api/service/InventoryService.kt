package film.inventory.api.service

import film.inventory.api.model.RentalFilm
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class InventoryService {

    fun getFilm(name: String): Single<RentalFilm> {
        return Single.just(RentalFilm(name))
    }
}