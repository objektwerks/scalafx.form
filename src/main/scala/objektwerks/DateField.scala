package objektwerks

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.geometry.Insets
import scalafx.scene.layout.HBox

class DateField(localDate: LocalDate) extends HBox:
  spacing = 3
  padding = Insets(3)

  val value = ObjectProperty[LocalDate](localDate)
