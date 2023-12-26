package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.control.Label
import scalafx.scene.layout.{GridPane, Region}

final class Validator()

final case class Field(label: Label,
                       component: Region,
                       validator: Validator)

final class Form(fields: List[Field]) extends GridPane:
  hgap = 6
  vgap = 6
  padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
  var row = 0
  for (field <- fields)
    val columnLabel = field.label
    add(columnLabel, columnIndex = 0, rowIndex = row)
    add(field.component, columnIndex = 1, rowIndex = row)
    row += 1