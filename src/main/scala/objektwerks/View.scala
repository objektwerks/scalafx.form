package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.VBox

final class View(model: Model):
  val rootPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List( Menu.build(model), ModelPane( ModelForm(model) ) )

  val scene = new Scene:
    root = rootPane