package objektwerks

import scalafx.collections.ObservableBuffer
import scalafx.scene.control.{ComboBox, Label}
import scalafx.geometry.Insets
import scalafx.scene.layout.{Priority, VBox}

import java.time.LocalDateTime

final class FormPane extends VBox:
  spacing = 6
  padding = Insets(6)
  
  val intLabel = new Label:
    text = "Int Field:"
  
  val intTextField = new IntTextField:
    text = "1"

  val doubleLabel = new Label:
    text = "Double Field:"

  val doubleTextField = new DoubleTextField:
    text = "1.1"

  val comboBox = new ComboBox[String]:
  	items = ObservableBuffer.from( List("a", "b", "c") )
  	value = "a"
  comboBox.prefWidth = 100

  val dateTimeLabel = new Label:
    text = "Date Time Field:"

  val dateTimeField = new DateTimeField( LocalDateTime.now )

  val fields = List(
    Field(intLabel, intTextField),
    Field(doubleLabel, doubleTextField),
    Field(dateTimeLabel, dateTimeField)
  )

  val form = Form(fields)

  children = List(form)
  VBox.setVgrow(form, Priority.Always)