package film.inventory.api

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("film.inventory.service")
                .mainClass(Application.javaClass)
                .start()
    }
}