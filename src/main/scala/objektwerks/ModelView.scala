package objektwerks

import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{ComboBox, Label}
import scalafx.scene.layout.{Priority, VBox}

final class ModelView(model: Model) extends VBox:
  alignment = Pos.CENTER
  padding = Insets(6)
  spacing = 6
  
  val intLabel = Label("Int Field:")
  val intTextField = new IntTextField:
    text = model.intProperty.value.toString
    text.onChange { (_, _, newValue) => model.intProperty.value = newValue.toInt }

  val doubleLabel = Label("Double Field:")
  val doubleTextField = new DoubleTextField:
    text = model.doubleProperty.value.toString
    text.onChange { (_, _, newValue) => model.doubleProperty.value = newValue.toDouble }

  val comboLabel = Label("ComboBox:")
  val comboBox = new ComboBox[String]:
  	items = ObservableBuffer.from(model.listProperty.value)
  	value = model.listProperty.value.head

  val dateTimeLabel = Label("Date Time Field:")
  val dateTimeField = new DateTimeField(model.datetimeProperty.value)

  val fields = List(
    intLabel -> intTextField,
    doubleLabel -> doubleTextField,
    comboLabel -> comboBox,
    dateTimeLabel -> dateTimeField
  )

  val form = Form(fields)
 
  children = List(form)
  VBox.setVgrow(this, Priority.Always)