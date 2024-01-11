package objektwerks

import java.text.{DecimalFormat, NumberFormat}

import scalafx.geometry.Insets
import scalafx.scene.control.{Slider, TextField, TextFormatter}
import scalafx.scene.layout.HBox
import scalafx.util.converter.FormatStringConverter

object NumberSlider:
  private def decimalFormat = DecimalFormat("####.#")
  private def integerFormat = NumberFormat.getIntegerInstance

  def decimalFormatConverter: FormatStringConverter[Number] = FormatStringConverter[Number](decimalFormat)
  def integerFormatConverter: FormatStringConverter[Number] = FormatStringConverter[Number](integerFormat)

class NumberSlider(numberAsText: String,
                   numberAsTextFormatConverter: FormatStringConverter[Number]) extends HBox:
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
    text = numberAsText
    textFormatter = new TextFormatter[Number](numberAsTextFormatConverter):
      value <== slider.value

  spacing = 3
  padding = Insets(6)
  children = List(textField, slider)

  def toDouble: Double = slider.value.toDouble
  def toInt: Int = slider.value.toInt