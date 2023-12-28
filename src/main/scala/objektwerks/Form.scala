package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.layout.{GridPane, Priority}
import scalafx.beans.property.ObjectProperty

final class Form(fields: List[Field]) extends GridPane:
  val isValid = ObjectProperty[Boolean](false)
  
  hgap = 6
  vgap = 6
  padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
  GridPane.setHgrow(this, Priority.Always)
  GridPane.setVgrow(this, Priority.Always)

  var row = 0
  for (field <- fields)
    field.control.onInputMethodTextChanged.onChange( (source, oldValue, newValue) => validate() )
    add(field.label, columnIndex = 0, rowIndex = row)
    add(field.control, columnIndex = 1, rowIndex = row)
    row += 1

  validate()

  private def validate(): Unit =
    var validations = 0
    for (field <- fields)
      if field.validator.validate() then validations += 1

    isValid.value = if validations == fields.length then true else false