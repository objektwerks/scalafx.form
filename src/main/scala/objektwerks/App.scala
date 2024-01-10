package objektwerks

import scalafx.application.JFXApp3

object App extends JFXApp3:
  override def start(): Unit =
    val model = Model()
    stage = new JFXApp3.PrimaryStage:
      scene = View(model).scene
      title = "App"