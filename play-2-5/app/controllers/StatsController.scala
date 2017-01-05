package controllers

import javax.inject._
import play.api.mvc._

class StatsController @Inject() extends Controller {

  def getStats = Action {
    Ok(((Runtime.getRuntime.totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024)).toString)
  }
}
