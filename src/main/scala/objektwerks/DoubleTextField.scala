package objektwerks

import scalafx.scene.control.{TextField, TextFormatter}
import scalafx.scene.control.TextFormatter.Change
import scalafx.util.converter.DoubleStringConverter

object DoubleTextField:
  val regex = """([0-9]+([.][0-9]*)?|[.][0-9]+)""".r

class DoubleTextField extends TextField: 
  val converter = DoubleStringConverter()
  val filter: Change => Change = { (change: Change) =>
    if DoubleTextField.regex.matches(change.controlNewText) then
      change // if double, make change
    else
      null // else make no change
  }
  textFormatter = TextFormatter[Double](converter, 0.0, filter)

  def double(default: Double): Double = text.value.toDoubleOption.getOrElse(default)