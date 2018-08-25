package co.tala.nairobijvm.nairobijvmsmsmodule.configs

import com.typesafe.config.Config
import play.api.ConfigLoader

case class GeneralConfig(appName: String, appVersion: String)


object GeneralConfig {
  val classificationKey = "general"
  implicit val configLoader = new ConfigLoader[GeneralConfig] {
    override def load(config: Config, path: String): GeneralConfig = {
      val configBase = config.getConfig(path)
      GeneralConfig(
        appName = configBase.getString("appName"),
        appVersion = configBase.getString("appVersion")
      )
    }
  }
}