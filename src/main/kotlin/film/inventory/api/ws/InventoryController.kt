package film.inventory.api.ws

import film.inventory.api.model.RentalFilm
import film.inventory.api.service.InventoryServiceImpl
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import io.reactivex.Single
import java.net.URI
import javax.validation.Valid
import io.micronaut.http.annotation.Delete




@Controller("/film")
class InventoryController(private val inventoryServiceImpl: InventoryServiceImpl) {

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{id}")
    fun getFilm(id: Long?): Single<RentalFilm> {
        return inventoryServiceImpl.findById(id)
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/")
    fun getAllFilms(): Single<List<RentalFilm>> {
        return inventoryServiceImpl.findAll()
    }

    //TODO: Add auth
    @Post("/")
    fun saveFilm(@Body @Valid film: RentalFilm): MutableHttpResponse<RentalFilm>? {
        inventoryServiceImpl.save(film)
        return HttpResponse
                .created(film)
                .headers { headers -> headers.location(toUri(film)) }
    }

    //TODO: Add auth
    @Post("/")
    fun updateFilm(@Body @Valid film: RentalFilm): HttpResponse<*> {
        inventoryServiceImpl.update(film.id, film)
        return HttpResponse
                .noContent<Any>()
                .header(HttpHeaders.LOCATION, toUri(film).path)
    }

    //TODO: Add auth
    @Delete("/{id}")
    fun delete(id: Long?): HttpResponse<*> {
        inventoryServiceImpl.deleteById(id)
        return HttpResponse.noContent<Any>()
    }

    private fun toUri(film: RentalFilm): URI {
        return URI.create("/film/" + film.id)
    }
}