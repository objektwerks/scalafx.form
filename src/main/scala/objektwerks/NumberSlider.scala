package objektwerks

import java.text.{DecimalFormat, NumberFormat}

import scalafx.geometry.Insets
import scalafx.scene.control.{Slider, TextField, TextFormatter}
import scalafx.scene.layout.HBox
import scalafx.util.converter.FormatStringConverter

class NumberSlider(textFieldText: String,
                   formatConverter: FormatStringConverter[Number]) extends HBox:
  val slider = new Slider:
    prefWidth = 600
    showTickLabels = true
    showTickMarks = true
    snapToTicks = true
    minorTickCount = 0

  val textField = new TextField:
    style = "-fx-background-color: #ececec;"
    editable = false
    prefWidth = 50
    text = textFieldText
    textFormatter = new TextFormatter[Number](formatConverter):
      value <== slider.value

  spacing = 3
  padding = Insets(6)
  children = List(textField, slider)

  def valueAsDouble: Double = slider.value.toDouble
  def valueAsInt: Int = slider.value.toInt