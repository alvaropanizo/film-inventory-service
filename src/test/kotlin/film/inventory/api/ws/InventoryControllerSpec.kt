package film.inventory.api.ws

import film.inventory.api.model.RentalFilm
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.*


object InventoryControllerSpec : Spek({
    describe("HelloController Suite") {
        var embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        var client: HttpClient = HttpClient.create(embeddedServer.url)

        it("test /film/{name} response with film name") {
            var rsp: RentalFilm = client.toBlocking().retrieve(
                    HttpRequest.GET<RentalFilm>("/film/PlanetoftheApes"),
                    RentalFilm::class.java)
            assertNotNull(rsp)
            assertEquals(rsp.name, "PlanetoftheApes")
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})