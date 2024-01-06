package objektwerks

import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Orientation, Pos}
import scalafx.scene.control.{Button, CheckBox, ChoiceBox, ComboBox, DatePicker, Label, ListView, RadioButton, Separator}
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
    text.onChange { (_, _, newValue) => model.textProperty.value = newValue }

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

  val checkBoxLabel = Label("CheckBox:")
  val checkBox = new CheckBox:
    selected = model.isChecked
    selected.onChange { (_, _, newValue ) => model.isCheckedProperty.value = newValue }

  val choiceBoxLabel = Label("ChoiceBox:")
  val choiceBox = new ChoiceBox[String]:
  	items = ObservableBuffer.from(model.choices)
  	value = model.choices.head
  choiceBox.value.onChange { (_, _, newValue) => model.choiceProperty.value = newValue }

  val comboBoxLabel = Label("ComboBox:")
  val comboBox = new ComboBox[String]:
  	items = ObservableBuffer.from(model.items)
  	value = model.items.head
  comboBox.value.onChange { (_, _, newValue) => model.itemProperty.value = newValue }

  val radioButtonLabel = Label("RadioButton:")
  val radioButton = RadioButton("0 / 1")
  radioButton.selected.onChange { (_, _, newValue ) => model.isRadioedProperty.value = newValue }

  val listViewLabel = Label("ListView:")
  val listView = new ListView[String]:
    items = ObservableBuffer.from(model.items)
  listView.getSelectionModel.selectedItemProperty.onChange { (_, _, newValue) => model.itemProperty.value = newValue }

  val dateLabel = Label("Date Picker:")
  val datePicker = new DatePicker:
    value = model.date
  datePicker.onAction = { _ => model.dateProperty.value = datePicker.value.value }

  val timeLabel = Label("Time Field:")
  val timeField = new TimeField(model.time)
  timeField.value.onChange { (_, _, newValue) => model.timeProperty.value = newValue }

  val dateTimeLabel = Label("Date Time Field:")
  val dateTimeField = new DateTimeField(model.datetime)
  dateTimeField.value.onChange { (_, _, newValue) => model.datetimeProperty.value = newValue }

  val fields = List(
    textLabel -> textField,
    intLabel -> intTextField,
    doubleLabel -> doubleTextField,
    intSliderLabel -> intSlider,
    doubleSliderLabel -> doubleSlider,
    checkBoxLabel -> checkBox,
    choiceBoxLabel -> choiceBox,
    comboBoxLabel -> comboBox,
    radioButtonLabel -> radioButton, // ToggleGroup is not a Node!
    listViewLabel -> listView,
    dateLabel -> datePicker,
    timeLabel -> timeField,
    dateTimeLabel -> dateTimeField
  )

  val form = Form(fields)

  val submitButton = new Button:
    alignment = Pos.CENTER
    text = "Submit"
    disable = false
    onAction = { _ => reset() }
 
  children = List(title, separator, form, submitButton)
  VBox.setVgrow(this, Priority.Always)

  def reset(): Unit =
    println(s"*** Modified model: ${model.propertiesToModel}")
    textField.text = model.text
    intTextField.text = model.int.toString
    doubleTextField.text = model.double.toString
    intSlider.slider.value = model.int
    doubleSlider.slider.value = model.double
    checkBox.selected = model.isChecked
    choiceBox.value = model.choices.head
    comboBox.value = model.items.head
    radioButton.selected = model.isRadioed
    datePicker.value = model.date
    timeField.value.value = model.time
    dateTimeField.value.value = model.datetime
    println(s"*** Reset model: ${model.propertiesToModel}")