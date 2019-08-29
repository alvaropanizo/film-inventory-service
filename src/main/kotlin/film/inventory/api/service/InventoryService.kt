package film.inventory.api.service

import film.inventory.api.model.RentalFilm
import io.reactivex.Single
import javax.validation.constraints.NotNull

interface InventoryService {

    fun findById(@NotNull id: Long?): Single<RentalFilm>

    fun save(@NotNull film: RentalFilm): Single<RentalFilm>

    fun deleteById(id: Long?) : Single<Int>

    fun findAll(): Single<List<RentalFilm>>

    fun update(@NotNull id: Long?, film: RentalFilm): Single<RentalFilm>
}
