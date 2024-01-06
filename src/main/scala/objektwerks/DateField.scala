package objektwerks

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.geometry.Insets
import scalafx.scene.control.Label
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
