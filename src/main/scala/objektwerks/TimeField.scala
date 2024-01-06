package objektwerks

import java.time.LocalTime

import scalafx.beans.property.ObjectProperty
import scalafx.geometry.Insets
import scalafx.scene.control.{Label, Spinner}
import scalafx.scene.layout.{HBox, Priority}

class TimeField(localTime: LocalTime) extends HBox:
  spacing = 3
  padding = Insets(3)

  val value = ObjectProperty[LocalTime](localTime)

  val hourLabel = new Label:
    prefHeight = 25
    text = "H:"

  val minuteLabel = new Label:
    prefHeight = 25
    text = "M:"
  
  val hourSpinner = Spinner[Int](min = 0, max = 23, initialValue = localTime.getHour, amountToStepBy = 1)
  hourSpinner.prefWidth = 75
  hourSpinner.value.onChange { (_, _, newValue) => value.value = value.value.withHour(newValue) }

  val minuteSpinner = Spinner[Int](min = 0, max = 59, initialValue = localTime.getMinute, amountToStepBy = 1)
  minuteSpinner.prefWidth = 75
  minuteSpinner.value.onChange { (_, _, newValue) => value.value = value.value.withMinute(newValue) }

  children = List(hourLabel, hourSpinner, minuteLabel, minuteSpinner)
  HBox.setHgrow(this, Priority.Always)

  def time = localTime.withHour( hourSpinner.value.value ).withMinute( minuteSpinner.value.value )