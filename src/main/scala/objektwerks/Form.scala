package objektwerks

import scalafx.scene.control.Label
import scalafx.geometry.Insets
import scalafx.scene.layout.{GridPane, Priority, Region}

final class Form(fields: List[(Label, Region)]) extends GridPane:
  hgap = 6
  vgap = 6
  padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
  GridPane.setHgrow(this, Priority.Always)
  GridPane.setVgrow(this, Priority.Always)

  var row = 0
  for ((label, region) <- fields)
    add(label, columnIndex = 0, rowIndex = row)
    add(region, columnIndex = 1, rowIndex = row)
    row += 1