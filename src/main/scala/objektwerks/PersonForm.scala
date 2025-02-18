package objektwerks

import scalafx.beans.binding.Bindings
import scalafx.beans.property.ObjectProperty
import scalafx.scene.control.{Label, TextField}
import scalafx.scene.layout.VBox

final case class Person(name: String):
  val nameProperty = ObjectProperty(name)
  nameProperty.bind( Bindings.createObjectBinding(() => this.name, nameProperty) )


final class PersonForm(person: Person) extends VBox:
  val personProperty = ObjectProperty(person)

  val labelName = Label("Name" )

  val textFieldName = new TextField():
    text <==> personProperty.value.nameProperty