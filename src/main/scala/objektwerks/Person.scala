package objektwerks

// import scalafx.beans.binding.Bindings
import scalafx.beans.property.ObjectProperty

final case class Person(name: String):
  val nameProperty = ObjectProperty(name)
  // throws bound value cannot be set exception
  // nameProperty.bind( Bindings.createObjectBinding(() => this.name, nameProperty) )