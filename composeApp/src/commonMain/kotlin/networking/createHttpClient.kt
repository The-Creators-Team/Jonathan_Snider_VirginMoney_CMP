package networking

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(engine: HttpClientEngine): HttpClient {
    return HttpClient(engine) {
        //adding configuration to the HttpClient, such as loggers, authentication
        //or Json parsing (ContentNegotiation)
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(
                json = Json {
                    //if an API call responds with json fields that our project doesn't recognize
                    //(probably because they were missing in our data classes) this prevents
                    //the app from crashing
                    ignoreUnknownKeys = true
                }
            )
        }
        //can be used to apply Authentication to API calls, such as OAuth with short lived
        //tokens or usernames and passwords
  /*      install(Auth){
            bearer {
                loadTokens {

                }
            }
        }*/
    }
}