package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.control.Label
import scalafx.scene.layout.{GridPane, Priority, Region}

trait Validator:
  def validate: Boolean

final class DefaultValidator extends Validator:
  def validate: Boolean = true

final case class Field(label: Label,
                       control: Region,
                       validator: Validator = DefaultValidator())

final class Form(fields: List[Field]) extends GridPane:
  hgap = 6
  vgap = 6
  padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
  var row = 0
  for (field <- fields)
    add(field.label, columnIndex = 0, rowIndex = row)
    add(field.control, columnIndex = 1, rowIndex = row)
    row += 1
  GridPane.setHgrow(this, Priority.Always)
  GridPane.setVgrow(this, Priority.Always)