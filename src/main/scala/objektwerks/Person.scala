package objektwerks

import scalafx.beans.binding.Bindings
import scalafx.beans.property.ObjectProperty

final case class Person(name: String):
  val nameProperty = ObjectProperty(name)
  nameProperty.bind( Bindings.createObjectBinding(() => this.name, nameProperty) )