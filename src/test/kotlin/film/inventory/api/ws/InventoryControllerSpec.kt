package film.inventory.api.ws

import film.inventory.api.model.RentalFilm
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull


object InventoryControllerSpec : Spek({
    describe("InventoryController test") {
        var embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        var client: HttpClient = HttpClient.create(embeddedServer.url)

        val addedFilm = RentalFilm("01", "PLA01", "Planet of the Apes")

        it("test /film/{id} response with film name") {
            var rsp: RentalFilm = client.toBlocking().retrieve(
                    HttpRequest.GET<RentalFilm>("/film/01"),
                    RentalFilm::class.java)
            assertNotNull(rsp)
            assertEquals(rsp.id, "01")
        }


        it("test /film/all response with film name") {
            var rsp: List<*> = client.toBlocking().retrieve(
                    HttpRequest.GET<List<RentalFilm>>("/film/all"),
                    List::class.java)
            assertNotNull(rsp)

            rsp.forEach {
                assertNotNull(it)
            }
        }

        it("test /film/addFilm response with film name") {
            var rsp: RentalFilm = client.toBlocking().retrieve(
                    HttpRequest.POST<RentalFilm>("/film/addFilm", addedFilm),
                    RentalFilm::class.java)
            assertNotNull(rsp)

            assertEquals(rsp.id, "01")
            assertEquals(rsp.filmId, "PLA01")
            assertEquals(rsp.name, "Planet of the Apes")
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})