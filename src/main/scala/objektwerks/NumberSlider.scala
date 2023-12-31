package objektwerks

import java.text.{DecimalFormat, NumberFormat}

import scalafx.geometry.Insets
import scalafx.scene.control.{Slider, TextField, TextFormatter}
import scalafx.scene.layout.HBox
import scalafx.util.converter.FormatStringConverter

object NumberSlider:
  def decimalFormat = DecimalFormat("####.#")
  def integerFormat = NumberFormat.getIntegerInstance

  def formatConverter(format: DecimalFormat): FormatStringConverter[Number] = FormatStringConverter[Number](format)
  def formatConverter(format: NumberFormat): FormatStringConverter[Number] = FormatStringConverter[Number](format)

class NumberSlider(textFieldText: String,
                   textFieldFormatConverter: FormatStringConverter[Number]) extends HBox:
  val slider = new Slider:
    prefWidth = 350
    showTickLabels = true
    showTickMarks = true
    snapToTicks = true
    minorTickCount = 0

  val textField = new TextField:
    style = "-fx-background-color: #ececec;"
    editable = false
    prefWidth = 50
    text = textFieldText
    textFormatter = new TextFormatter[Number](textFieldFormatConverter):
      value <== slider.value

  spacing = 3
  padding = Insets(6)
  children = List(textField, slider)

  def valueAsDouble: Double = slider.value.toDouble
  def valueAsInt: Int = slider.value.toInt