package film.inventory.api.ws

import film.inventory.api.service.InventoryService
import film.inventory.api.model.RentalFilm
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.reactivex.Single


@Controller("/film")
class InventoryController(private val inventoryService: InventoryService) {

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{id}")
    fun getFilm(id: String): Single<RentalFilm> {
        return inventoryService.getFilm(id)
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/all")
    fun getAllFilms(): Single<List<RentalFilm>> {
        return inventoryService.getAllFilms()
    }

    //TODO: Add auth
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/addFilm")
    fun addFilm(@Body film: RentalFilm): Single<RentalFilm> {
        return inventoryService.saveAndUpdateFilm(film)
    }

}