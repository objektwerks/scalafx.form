package objektwerks

import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{ComboBox, Label}
import scalafx.scene.layout.{Priority, VBox}

import NumberSlider.*

final class ModelView(model: Model) extends VBox:
  alignment = Pos.CENTER
  padding = Insets(6)
  spacing = 6
  
  val intLabel = Label("Int Field:")
  val intTextField = new IntTextField:
    text = model.int.toString
    text.onChange { (_, _, newValue) => model.intProperty.value = newValue.toInt }

  val doubleLabel = Label("Double Field:")
  val doubleTextField = new DoubleTextField:
    text = model.double.toString
    text.onChange { (_, _, newValue) => model.doubleProperty.value = newValue.toDouble }

  val intSliderLabel = Label("Int Slider:")
  val intSlider = new NumberSlider(textFieldText = 5.toString,
                                   textFieldFormatConverter = formatConverter(integerFormat)):
                    slider.min = 0
                    slider.max = 10
                    slider.majorTickUnit = 1
                    slider.value = 5

  val dateTimeLabel = Label("Date Time Field:")
  val dateTimeField = new DateTimeField(model.datetime)
  dateTimeField.value.onChange { (_, _, newValue) => model.datetimeProperty.value = newValue }

  val comboLabel = Label("ComboBox:")
  val comboBox = new ComboBox[String]:
  	items = ObservableBuffer.from(model.list)
  	value = model.list.head
  comboBox.value.onChange { (_, _, newValue) => model.listItemProperty.value = newValue }

  val fields = List(
    intLabel -> intTextField,
    doubleLabel -> doubleTextField,
    intSliderLabel -> intSlider,
    comboLabel -> comboBox,
    dateTimeLabel -> dateTimeField
  )

  val form = Form(fields)
 
  children = List(form)
  VBox.setVgrow(this, Priority.Always)