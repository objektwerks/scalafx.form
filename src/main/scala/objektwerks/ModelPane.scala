package objektwerks

import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Orientation, Pos}
import scalafx.scene.control.{Button, CheckBox, ChoiceBox, ComboBox, DatePicker, Label, ListView, Separator}
import scalafx.scene.layout.{Priority, VBox}

class ModelPane(modelForm: ModelForm) extends VBox:
  alignment = Pos.CENTER
  padding = Insets(6)
  spacing = 6

  val title = Label("~ Model ~")

  val submit = new Button:
    alignment = Pos.CENTER
    text = "Submit"
    disable = false
    onAction = { _ => println(s"*** Model: ${model.propertiesToModel}") }
 
  children = List(
    title,
    Separator(Orientation.Horizontal),
    form,
    Separator(Orientation.Horizontal),
    submit
  )
  VBox.setVgrow(this, Priority.Always)