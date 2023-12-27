package objektwerks

import scalafx.scene.control.Label
import scalafx.geometry.Insets
import scalafx.scene.layout.{Priority, VBox}

final class FormPane extends VBox:
  spacing = 6
  padding = Insets(6)
  
  val intLabel = new Label:
    text = "Int Field:"
  
  val intTextField = new IntTextField:
    text = "1"

  val doubleLabel = new Label:
    text = "Double Field:"

  val doubleTextField = new DoubleTextField:
    text = "1.1"

  val fields = List(
    Field(intLabel, intTextField),
    Field(doubleLabel, doubleTextField)
  )

  val form = Form(fields)

  children = List(form)
  VBox.setVgrow(form, Priority.Always)