package routes.profile

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import routes.auth.authRouting

fun Application.simpleAuthRouting(){
    routing {
        authRouting()
        getUserProfile()
    }
}
fun Route.getUserProfile() {
    authenticate() {
        get("/profile") {
            val principal = call.principal<JWTPrincipal>()
            val username = principal!!.payload.getClaim("username").asString()
            println("This is the username: $username")
            call.respondText(text = "Hey there, $username", status = HttpStatusCode.OK)
        }
    }
}