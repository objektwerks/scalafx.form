package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.layout.{GridPane, Priority}

final class Form(fields: List[Field]) extends GridPane:
  hgap = 6
  vgap = 6
  padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
  GridPane.setHgrow(this, Priority.Always)
  GridPane.setVgrow(this, Priority.Always)

  var row = 0
  for (field <- fields)
    add(field.label, columnIndex = 0, rowIndex = row)
    add(field.control, columnIndex = 1, rowIndex = row)
    row += 1

  def validate(): Boolean =
    var validations = 0
    for (field <- fields)
      if field.validator.validate() then validations += 1

    validations == fields.length