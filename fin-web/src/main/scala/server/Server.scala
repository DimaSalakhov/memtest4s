package server

import io.finch._
import com.twitter.finagle.{ Http, Service, http }
import com.twitter.util.{ Await, Future }

object Server extends App {
  val api: Endpoint[String] = get("stats") { Ok(((Runtime.getRuntime.totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024)).toString) }

  Await.result(Http.server.serve(":8080", api.toServiceAs[Text.Plain]))

}
