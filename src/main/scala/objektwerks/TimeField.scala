package objektwerks

import java.time.LocalTime

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Label, Spinner}
import scalafx.scene.layout.{HBox, Priority}

class TimeField(localTime: LocalTime) extends HBox:
  spacing = 3
  padding = Insets(3)

  val labelHour = new Label:
    alignment = Pos.CENTER_LEFT
    text = "H:"

  val labelMinute = new Label:
    alignment = Pos.CENTER_LEFT
    text = "M:"
  
  val hourSpinner = Spinner[Int](min = 0, max = 23, initialValue = localTime.getHour, amountToStepBy = 1)
  val minuteSpinner = Spinner[Int](min = 0, max = 59, initialValue = localTime.getMinute, amountToStepBy = 1)

  children = List(labelHour, hourSpinner, labelMinute, minuteSpinner)
  HBox.setHgrow(this, Priority.Always)

  def time = localTime.withHour( hourSpinner.value.value ).withMinute( minuteSpinner.value.value )