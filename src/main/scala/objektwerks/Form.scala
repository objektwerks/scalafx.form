package objektwerks

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.Label
import scalafx.scene.layout.{GridPane, Region}

final case class Validator()

final case class Field(validator: Validator)

final case class Fields(fields: List[Field])

final class Form(controls: List[(String, Region)]) extends GridPane:
  hgap = 6
  vgap = 6
  padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
  var row = 0
  for ((label, control) <- controls)
    val columnLabel = new Label:
      alignment = Pos.CenterLeft
      text = label
    add(columnLabel, columnIndex = 0, rowIndex = row)
    add(control, columnIndex = 1, rowIndex = row)
    row += 1