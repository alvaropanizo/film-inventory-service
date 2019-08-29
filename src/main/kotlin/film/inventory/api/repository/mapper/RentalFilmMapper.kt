package film.inventory.api.repository.mapper

import film.inventory.api.model.RentalFilm

interface RentalFilmMapper<Any> {
    fun toRentalFilm(source: Any): RentalFilm

    fun toRentalFilm(source: Iterable<Any>): List<RentalFilm>

    fun toSource(source: RentalFilm): Any

    fun toSource(source: List<RentalFilm>): List<Any>
}