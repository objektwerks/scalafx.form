package objektwerks

import scalafx.Includes.*
import scalafx.geometry.Orientation
import scalafx.scene.control.{Dialog, Separator}
import scalafx.scene.layout.VBox

class ModelDialog(form: ModelForm) extends Dialog[Model]:
  initOwner(App.stage)
  title = "Model"
  headerText = "~ Model ~"

  dialogPane().content = new VBox:
    children = List(Separator(Orientation.Horizontal), form)