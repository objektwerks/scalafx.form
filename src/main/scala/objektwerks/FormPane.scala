package objektwerks

import scalafx.collections.ObservableBuffer
import scalafx.scene.control.{ComboBox, Label}
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.layout.{Priority, VBox}

import java.time.LocalDateTime

final class FormPane extends VBox:
  alignment = Pos.CENTER
  padding = Insets(6)
  spacing = 6
  
  val intLabel = Label("Int Field:")
  val intTextField = new IntTextField:
    text = "1"

  val doubleLabel = Label("Double Field:")
  val doubleTextField = new DoubleTextField:
    text = "1.1"

  val comboLabel = Label("ComboBox:")
  val comboBox = new ComboBox[String]:
  	items = ObservableBuffer.from( List("abc", "def", "ghi") )
  	value = "abc"

  val dateTimeLabel = Label("Date Time Field:")
  val dateTimeField = new DateTimeField( LocalDateTime.now )

  val fields = List(
    intLabel -> intTextField,
    doubleLabel -> doubleTextField,
    comboLabel -> comboBox,
    dateTimeLabel -> dateTimeField
  )

  val form = Form(fields)
 
  children = List(form)
  VBox.setVgrow(this, Priority.Always)