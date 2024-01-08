package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.VBox

class View:
  val modelPane = ModelPane( Model() )
  
  val contentPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List(modelPane)

  val scene = new Scene:
    root = contentPane
    stylesheets = List("/app.css")