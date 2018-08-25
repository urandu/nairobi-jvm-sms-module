package co.tala.nairobijvm.nairobijvmsmsmodule.controllers

import co.tala.nairobijvm.nairobijvmsmsmodule.configs.GeneralConfig
import co.tala.nairobijvm.nairobijvmsmsmodule.utils.NamedLogger
import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class NairobijvmsmsmoduleController @Inject()(cc: ControllerComponents, configuration: Configuration)
  extends AbstractController(cc) with NamedLogger {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Logger.debug("default action access")
    logger.debug("custom action access")
    val general = configuration.get[GeneralConfig](GeneralConfig.classificationKey)
    Ok(s"The app name is: ${general.appName}"+ s"\n App version:  ${general.appVersion} ")
  }

  def logName(name:String) = Action { implicit request: Request[AnyContent] =>
    logger.debug(name)
    Ok(s"logged name: ${name}")
  }
}
