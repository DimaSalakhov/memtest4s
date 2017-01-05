import org.http4s._
import org.http4s.server._
import org.http4s.dsl._

import _root_.argonaut._, Argonaut._
import org.http4s.argonaut._

object Routes {
  val service = HttpService {
    case GET -> Root ⇒
      Ok("Memory: " + ((Runtime.getRuntime.totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024)))
  }
}