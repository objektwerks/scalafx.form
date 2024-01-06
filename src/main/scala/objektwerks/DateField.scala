package objektwerks

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.geometry.Insets
import scalafx.scene.control.{Label, Spinner}
import scalafx.scene.layout.HBox

class DateField(localDate: LocalDate) extends HBox:
  spacing = 3
  padding = Insets(3)

  val value = ObjectProperty[LocalDate](localDate)

  val labelYear = new Label:
    prefHeight = 25
    text = "YYYY:"

  val labelMonth = new Label:
    prefHeight = 25
    text = "MM:"

  val labelDay = new Label:
    prefHeight = 25
    text = "DD:"

  val yearSpinner = Spinner[Int](min = localDate.getYear - 1, max = localDate.getYear, initialValue = localDate.getYear, amountToStepBy = 1)
  val monthSpinner = Spinner[Int](min = 1, max = 12, initialValue = localDate.getMonthValue, amountToStepBy = 1)
  val daySpinner = Spinner[Int](min = 1, max = 31, initialValue = localDate.getDayOfMonth, amountToStepBy = 1)
