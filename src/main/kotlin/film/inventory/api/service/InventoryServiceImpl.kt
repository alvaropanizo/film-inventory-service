package film.inventory.api.service

import film.inventory.api.model.RentalFilm
import film.inventory.api.repository.FilmRepositoryGateway
import io.reactivex.Single
import javax.inject.Singleton


@Singleton
class InventoryServiceImpl(private val filmRepositoryGateway: FilmRepositoryGateway) : InventoryService {

    override fun findById(id: Long?): Single<RentalFilm> {
       return Single.just(filmRepositoryGateway.findOne(id))
    }

    override fun save(film: RentalFilm): Single<RentalFilm> {
        return Single.just(filmRepositoryGateway.save(film))
    }

    override fun deleteById(id: Long?): Single<Int> {
       return Single.just(filmRepositoryGateway.delete(id))
    }

    override fun findAll(): Single<List<RentalFilm>> {
        return Single.just(filmRepositoryGateway.findAll())
    }

    override fun update(id: Long?, film: RentalFilm): Single<RentalFilm> {
        return Single.just(filmRepositoryGateway.update(id, film))
    }

}