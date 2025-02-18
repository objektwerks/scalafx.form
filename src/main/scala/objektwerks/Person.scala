package objektwerks

import scalafx.beans.property.ObjectProperty
import scalafx.beans.binding.Bindings

final case class Person(name: String):
  val nameProperty = ObjectProperty(name)
  nameProperty.bind( Bindings.createObjectBinding(() => this.name, nameProperty) )