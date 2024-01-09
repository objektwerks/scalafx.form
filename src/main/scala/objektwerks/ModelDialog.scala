package objektwerks

import scalafx.Includes.*
import scalafx.geometry.Orientation
import scalafx.scene.control.{ButtonType, Dialog, Separator}
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.layout.VBox

class ModelDialog(form: ModelForm) extends Dialog[Model]:
  initOwner(App.stage)
  title = "Model"
  headerText = "~ Model ~"

  dialogPane().content = new VBox:
    children = List(Separator(Orientation.Horizontal), form, Separator(Orientation.Horizontal))

  val submitButtonType = new ButtonType("Submit", ButtonData.OKDone)
  dialogPane().buttonTypes = List(submitButtonType, ButtonType.Cancel)

  resultConverter = dialogButton =>
    if dialogButton == submitButtonType then form.model.propertiesToModel
    else null