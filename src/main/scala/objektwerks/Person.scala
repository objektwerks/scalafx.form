package objektwerks

// import scalafx.beans.binding.Bindings
import scalafx.beans.property.StringProperty

final case class Person(name: String):
  val nameProperty = StringProperty(name)
  // throws bound value cannot be set exception
  // nameProperty.bind( Bindings.createObjectBinding(() => this.name, nameProperty) )