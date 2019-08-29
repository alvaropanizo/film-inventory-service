package film.inventory.api.repository

import film.inventory.api.model.RentalFilm

class FilmRepositoryGateway : FilmRepository<RentalFilm> {
    override fun findOne(id: Long?): RentalFilm {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(film: RentalFilm): RentalFilm {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Long?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<RentalFilm> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(id: Long?, film: RentalFilm): RentalFilm {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}