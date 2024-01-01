package objektwerks

import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Orientation, Pos}
import scalafx.scene.control.{Button, CheckBox, ComboBox, Label, Separator}
import scalafx.scene.layout.{Priority, VBox}

import NumberSlider.*

final class ModelView(model: Model) extends VBox:
  alignment = Pos.CENTER
  padding = Insets(6)
  spacing = 6

  val title = Label("~ Form ~")
  val separator = Separator(Orientation.Horizontal)

  val textLabel = Label("Text Field:")
  val textField = new NonEmptyTextField:
    text = model.text
    text.onChange { (_, _, newValue) => if newValue.nonEmpty then model.textProperty.value = newValue }

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
                                   textFieldFormatConverter = integerFormatConverter):
                    slider.min = model.intRange.start
                    slider.max = model.intRange.end
                    slider.majorTickUnit = 1
                    slider.value = model.intRangeValue
                    slider.value.onChange { (_, _, newValue) => model.intRangeValueProperty.value = newValue.intValue }

  val doubleSliderLabel = Label("Double Slider:")
  val doubleSlider = new NumberSlider(textFieldText = model.double.toString,
                                      textFieldFormatConverter = decimalFormatConverter):
                    slider.min = model.doubleRange.start.toDouble
                    slider.max = model.doubleRange.end.toDouble
                    slider.minorTickCount = 1
                    slider.majorTickUnit = 1.0
                    slider.value = model.double
                    slider.value.onChange { (_, _, newValue) => model.doubleRangeValueProperty.value = newValue.doubleValue }

  val comboBoxLabel = Label("ComboBox:")
  val comboBox = new ComboBox[String]:
  	items = ObservableBuffer.from(model.list)
  	value = model.list.head
  comboBox.value.onChange { (_, _, newValue) => model.listItemProperty.value = newValue }

  val checkBoxLabel = Label("CheckBox:")
  val checkBox = new CheckBox:
    selected = model.isSelected
    selected.onChange { (_, _, newValue ) => model.isSelectedProperty.value = newValue }

  val dateTimeLabel = Label("Date Time Field:")
  val dateTimeField = new DateTimeField(model.datetime)
  dateTimeField.value.onChange { (_, _, newValue) => model.datetimeProperty.value = newValue }

  val fields = List(
    textLabel -> textField,
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
      println(s"*** Modified model: ${model.propertiesToModel}")
      textField.text = model.text
      intTextField.text = model.int.toString
      doubleTextField.text = model.double.toString
      intSlider.slider.value = model.int
      doubleSlider.slider.value = model.double
      comboBox.value = model.list.head
      checkBox.selected = model.isSelected
      dateTimeField.value.value = model.datetime
      println(s"*** Reset model: ${model.propertiesToModel}")
    }
 
  children = List(title, separator, form, submitButton)
  VBox.setVgrow(this, Priority.Always)