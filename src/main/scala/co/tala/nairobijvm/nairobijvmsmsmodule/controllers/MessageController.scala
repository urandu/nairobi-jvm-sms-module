package co.tala.nairobijvm.nairobijvmsmsmodule.controllers

import co.tala.nairobijvm.nairobijvmsmsmodule.configs.GeneralConfig
import co.tala.nairobijvm.nairobijvmsmsmodule.models.SendMessageRequest
import co.tala.nairobijvm.nairobijvmsmsmodule.utils.NamedLogger
import javax.inject._
import play.api._
import play.api.libs.json.{JsError, JsPath, JsValue, JsonValidationError}
import play.api.mvc._

import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class MessageController @Inject()(cc: ControllerComponents, configuration: Configuration)
  extends AbstractController(cc) with NamedLogger {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def message: Action[JsValue] = Action(parse.json){ request: Request[JsValue] =>
    val requestBody: JsValue = request.body
    logger.info(s"Received send message request with $requestBody")

    requestBody.validate[SendMessageRequest].fold(
      (error: Seq[(JsPath, Seq[JsonValidationError])]) => {
        logger.warn("Invalid sendMessageRequest payload")
        Future.successful(BadRequest(JsError.toJson(error)))
      },
      (sendMessageRequest: SendMessageRequest) => {
        logger.info(s"Received  valid sendMessageRequest")
       // messageService.sendMessage(sendMessageRequest).map(_ => Accepted)
      }
    )

    Ok


  }


}
