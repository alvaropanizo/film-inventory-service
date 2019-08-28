package film.inventory.api.ws

import film.inventory.api.service.InventoryService
import film.inventory.api.model.RentalFilm
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single

@Controller("/")
class InventoryController(private val inventoryService: InventoryService) {

    @Get("/film/{name}")
    fun getFilm(name: String): Single<RentalFilm> {
        return inventoryService.getFilm(name)
    }
}