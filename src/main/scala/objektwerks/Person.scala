package objektwerks

import scalafx.beans.property.StringProperty

final case class Person(name: String):
  val nameProperty = StringProperty(name)