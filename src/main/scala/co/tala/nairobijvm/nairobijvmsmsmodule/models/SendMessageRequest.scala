package co.tala.nairobijvm.nairobijvmsmsmodule.models

import play.api.libs.json.{Format, Json}


case class SendMessageRequest(
                             message:String,
                             destination:String,
                             message_type:String)
object SendMessageRequest{
  implicit val formats: Format[SendMessageRequest] = Json.format[SendMessageRequest]
}