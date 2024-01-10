package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.VBox

final class View(model: Model):
  val menuBar = Menu.build(model)
  val modelPane = ModelPane( ModelForm(model) )
  
  val contentPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List(menuBar, modelPane)

  val scene = new Scene:
    root = contentPane