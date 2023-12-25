package objektwerks

import com.typesafe.scalalogging.LazyLogging

import scalafx.application.JFXApp3

object App extends JFXApp3 with LazyLogging:

  override def start(): Unit =
    stage = new JFXApp3.PrimaryStage:
      scene = View().scene
      title = "Form"
      maxWidth = 400
      maxHeight = 300
    logger.info("*** App started.")


  override def stopApp(): Unit =
    logger.info("*** App stopped.")