import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.config.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.sessions.*
import kotlinx.coroutines.runBlocking
import models.user.User
import routes.auth.authRouting
import routes.profile.simpleAuthRouting
import utils.Database
import utils.TokenManager

fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    val config = HoconApplicationConfig(ConfigFactory.load())
    val tokenManager = TokenManager(config)
    install(Authentication) {
        jwt {
            verifier(tokenManager.verifyToken())
            realm = config.property("realm").getString()
            validate { jwtCredential ->
                if (!jwtCredential.payload.getClaim("username").asString().isNullOrEmpty()) {
                    JWTPrincipal(payload = jwtCredential.payload)
                } else {
                    null
                }
            }
        }
    }
    install(ContentNegotiation) {
        gson()
    }
    simpleAuthRouting()
}