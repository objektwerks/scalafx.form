package objektwerks

import scalafx.Includes.*
import scalafx.geometry.{Orientation, Pos}
import scalafx.scene.control.{ButtonType, Dialog, Label, Separator}
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.layout.VBox

final class ModelDialog(form: ModelForm) extends Dialog[Model]:
  initOwner(App.stage)
  title = "Model"

  val header = Label("~ Model ~")

  dialogPane().content = new VBox:
    alignment = Pos.CENTER
    children = List(header, Separator(Orientation.Horizontal), form, Separator(Orientation.Horizontal))

  val submitButtonType = new ButtonType("Submit", ButtonData.OKDone)
  dialogPane().buttonTypes = List(submitButtonType, ButtonType.Cancel)

  resultConverter = dialogButton =>
    if dialogButton == submitButtonType then form.model.copyProperties
    else null