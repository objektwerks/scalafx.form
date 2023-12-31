package objektwerks

import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Button, CheckBox, ComboBox, Label}
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
  val intSlider = new NumberSlider(textFieldText = model.int.toString,
                                   textFieldFormatConverter = formatConverter(integerFormat)):
                    slider.min = 0
                    slider.max = 10
                    slider.majorTickUnit = 1
                    slider.value = model.int

  val doubleSliderLabel = Label("Double Slider:")
  val doubleSlider = new NumberSlider(textFieldText = model.double.toString,
                                      textFieldFormatConverter = formatConverter(decimalFormat)):
                    slider.min = 0.0
                    slider.max = 10.0
                    slider.minorTickCount = 1
                    slider.majorTickUnit = 1.0
                    slider.value = model.double

  val comboBoxLabel = Label("ComboBox:")
  val comboBox = new ComboBox[String]:
  	items = ObservableBuffer.from(model.list)
  	value = model.list.head
  comboBox.value.onChange { (_, _, newValue) => model.listItemProperty.value = newValue }

  val checkBoxLabel = Label("CheckBox:")
  val checkBox = new CheckBox:
    selected = model.isSelected

  val dateTimeLabel = Label("Date Time Field:")
  val dateTimeField = new DateTimeField(model.datetime)
  dateTimeField.value.onChange { (_, _, newValue) => model.datetimeProperty.value = newValue }

  val fields = List(
    intLabel -> intTextField,
    doubleLabel -> doubleTextField,
    intSliderLabel -> intSlider,
    doubleSliderLabel -> doubleSlider,
    comboBoxLabel -> comboBox,
    checkBoxLabel -> checkBox,
    dateTimeLabel -> dateTimeField
  )

  val form = Form(fields)

  val submitButton = new Button:
    alignment = Pos.CENTER
    text = "Submit"
    disable = false
    onAction = { _ =>
      intTextField.text = model.int.toString
      doubleTextField.text = model.double.toString
      intSlider.slider.value = model.int
      doubleSlider.slider.value = model.double
      comboBox.value = model.list.head
      checkBox.selected = model.isSelected
      dateTimeField.value.value = model.datetime
    }
 
  children = List(form, submitButton)
  VBox.setVgrow(this, Priority.Always)