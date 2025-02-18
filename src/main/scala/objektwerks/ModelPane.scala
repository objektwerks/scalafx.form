package objektwerks

import scalafx.geometry.{Insets, Orientation, Pos}
import scalafx.scene.control.{Button, Label, Separator}
import scalafx.scene.layout.{Priority, VBox}

final class ModelPane(form: ModelForm) extends VBox:
  alignment = Pos.CENTER
  padding = Insets(6)
  spacing = 6

  val title = Label("~ Model ~")

  val submit = new Button:
    alignment = Pos.CENTER
    text = "Submit"
    disable = false
    onAction = { _ => println(s"*** Model Pane: ${form.model.copyProperties}") }
 
  children = List(
    title,
    Separator(Orientation.Horizontal),
    form,
    Separator(Orientation.Horizontal),
    submit
  )
  VBox.setVgrow(this, Priority.Always)