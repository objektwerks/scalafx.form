package objektwerks

import scalafx.scene.control.{TextField, TextFormatter}
import scalafx.scene.control.TextFormatter.Change

class NonEmptyTextField extends TextField:
  val filter: Change => Change = { (change: Change) =>
    if change.text.nonEmpty then
      change // if nonempty, make change
    else
      change.text = "" // else make no change
      change
  }