package objektwerks

import scalafx.collections.ObservableBuffer
import scalafx.scene.control.{ComboBox, Label}
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.layout.{Priority, VBox}

final class FormPane(model: Model) extends VBox:
  alignment = Pos.CENTER
  padding = Insets(6)
  spacing = 6
  
  val intLabel = Label("Int Field:")
  val intTextField = new IntTextField(model.int)

  val doubleLabel = Label("Double Field:")
  val doubleTextField = new DoubleTextField(model.double)

  val comboLabel = Label("ComboBox:")
  val comboBox = new ComboBox[String]:
  	items = ObservableBuffer.from(model.list)
  	value = model.list.head

  val dateTimeLabel = Label("Date Time Field:")
  val dateTimeField = new DateTimeField(model.datetime)

  val fields = List(
    intLabel -> intTextField,
    doubleLabel -> doubleTextField,
    comboLabel -> comboBox,
    dateTimeLabel -> dateTimeField
  )

  val form = Form(fields)
 
  children = List(form)
  VBox.setVgrow(this, Priority.Always)