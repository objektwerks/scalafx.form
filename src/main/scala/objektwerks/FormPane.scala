package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.layout.VBox

final class FormPane extends VBox:
  spacing = 6
  padding = Insets(6)
  
  val intTextField = new IntTextField:
    text = "1"

  val doubleTextField = new DoubleTextField:
    text = "1.1"
    