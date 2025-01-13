package mobi.sevenwinds.app.author

import com.papsign.ktor.openapigen.route.info
import com.papsign.ktor.openapigen.route.path.normal.NormalOpenAPIRoute
import com.papsign.ktor.openapigen.route.path.normal.post
import com.papsign.ktor.openapigen.route.response.respond
import com.papsign.ktor.openapigen.route.route
import org.joda.time.DateTime


fun NormalOpenAPIRoute.author() {
    route("/author") {
        route("/add").post<Unit, AuthorResponse, AuthorCreateRequest>(info("Добавить автора")) { _, body ->
            respond(AuthorService.addAuthor(body.fullName))
        }
    }
}

data class AuthorCreateRequest(val fullName: String)

data class AuthorRecord(
    val fullName: String,
    val createdAt: DateTime
)

data class AuthorResponse(
    val id: Int,
    val fullName: String,
    val createdAt: String
)