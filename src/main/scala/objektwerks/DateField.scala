package objektwerks

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.geometry.Insets
import scalafx.scene.control.{Label, Spinner}
import scalafx.scene.layout.{HBox, Priority}

class DateField(localDate: LocalDate) extends HBox:
  spacing = 3
  padding = Insets(3)

  val value = ObjectProperty[LocalDate](localDate)

  val yearLabel = new Label:
    prefHeight = 25
    text = "YYYY:"

  val monthLabel = new Label:
    prefHeight = 25
    text = "MM:"

  val dayLabel = new Label:
    prefHeight = 25
    text = "DD:"

  val yearSpinner = Spinner[Int](min = localDate.getYear - 1, max = localDate.getYear, initialValue = localDate.getYear, amountToStepBy = 1)
  yearSpinner.prefWidth = 75
  yearSpinner.value.onChange { (_, _, newValue) => value.value = value.value.withYear(newValue) }

  val monthSpinner = Spinner[Int](min = 1, max = 12, initialValue = localDate.getMonthValue, amountToStepBy = 1)
  monthSpinner.prefWidth = 75
  monthSpinner.value.onChange { (_, _, newValue) => value.value = value.value.withMonth(newValue) }

  val daySpinner = Spinner[Int](min = 1, max = 31, initialValue = localDate.getDayOfMonth, amountToStepBy = 1)
  daySpinner.prefWidth = 75
  daySpinner.value.onChange { (_, _, newValue) => value.value = value.value.withDayOfMonth(newValue) }

  children = List(yearLabel, yearSpinner, monthLabel, monthSpinner, dayLabel, daySpinner)
  HBox.setHgrow(this, Priority.Always)

  def date = localDate.withYear( yearSpinner.value.value ).withMonth( monthSpinner.value.value ).withDayOfMonth( daySpinner.value.value )