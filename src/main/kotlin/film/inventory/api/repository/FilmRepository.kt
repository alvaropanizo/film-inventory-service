package film.inventory.api.repository

import film.inventory.api.model.RentalFilm

interface FilmRepository<Any> {
    fun findOne(id: Long?): RentalFilm

    fun save(film: Any): RentalFilm

    fun delete(id: Long?): Int

    fun findAll(): Iterable<Any>

    fun update(id: Long?, film: Any): Any
}