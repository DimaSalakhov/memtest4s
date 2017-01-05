import org.http4s.server.blaze.BlazeBuilder

object ExampleApp extends App {
  BlazeBuilder.bindHttp(8081)
    .mountService(Routes.service, "/")
    .run
    .awaitShutdown()
}