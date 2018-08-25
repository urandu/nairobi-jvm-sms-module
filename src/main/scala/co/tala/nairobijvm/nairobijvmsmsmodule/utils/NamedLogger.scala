package co.tala.nairobijvm.nairobijvmsmsmodule.utils

import play.api.Logger

trait NamedLogger {
 val logger = Logger(this.getClass)
}
