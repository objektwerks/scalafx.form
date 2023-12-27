package objektwerks

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import scalafx.beans.property.ObjectProperty
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Button, Label, Spinner}
import scalafx.scene.layout.{GridPane, HBox, Priority, VBox}
import scalafx.stage.Popup

final class DateTimeField(localDateTime: LocalDateTime) extends HBox:
  spacing = 3
  padding = Insets(3)

  val value: ObjectProperty[LocalDateTime] = ObjectProperty(localDateTime)

  def format(localDateTime: LocalDateTime): String = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME)

  private val localDateTimeLabel = new Label:
    alignment = Pos.CENTER_LEFT
    text = format(localDateTime)

  private val localDateTimeButton = new Button:
    text = "..."
    disable = false
    onAction = { _ => showPopup() }

  children = List(localDateTimeLabel, localDateTimeButton)
  HBox.setHgrow(this, Priority.Always)

  private def showPopup(): Unit =
    val popup = Popup()
    popup.setHideOnEscape(false)
    val popupView = PopupView(value.value, popup, popupValue)
    popup.content.addOne(popupView)
    popup.show(App.stage)

  private def popupValue(popupLocalDateTime: LocalDateTime): Unit =
    value.value = popupLocalDateTime
    localDateTimeLabel.text = format(popupLocalDateTime)

private final class PopupView(localDateTime: LocalDateTime,
                              popup: Popup,
                              popupValue: (LocalDateTime) => Unit) extends VBox: 
  val yearSpinner = Spinner[Int](min = localDateTime.getYear - 1, max = localDateTime.getYear, initialValue = localDateTime.getYear, amountToStepBy = 1)
  val monthSpinner = Spinner[Int](min = 1, max = 12, initialValue = localDateTime.getMonthValue, amountToStepBy = 1)
  val daySpinner = Spinner[Int](min = 1, max = 31, initialValue = localDateTime.getDayOfMonth, amountToStepBy = 1)
  val hourSpinner = Spinner[Int](min = 0, max = 23, initialValue = localDateTime.getHour, amountToStepBy = 1)
  val minuteSpinner = Spinner[Int](min = 0, max = 59, initialValue = localDateTime.getMinute, amountToStepBy = 1)

  val controls = List[(String, Spinner[Int])](
    "Year:" -> yearSpinner,
    "Month:" -> monthSpinner,
    "Time:" -> daySpinner,
    "Hour:" -> hourSpinner,
    "Minute:" -> minuteSpinner
  )

  val selector = buildGridPane(controls)

  val closeButton = new Button:
    alignment = Pos.CENTER
    text = "Close"
    disable = false
    onAction = { _ =>
      popup.hide()
      popupValue( value() )
    }

  children = List(selector, closeButton)
  VBox.setVgrow(this, Priority.Always)

  private def value(): LocalDateTime =
    LocalDateTime
      .of(
        yearSpinner.value.value,
        monthSpinner.value.value,
        daySpinner.value.value,
        hourSpinner.value.value,
        minuteSpinner.value.value
      )

  private def buildGridPane(controls: List[(String, Spinner[Int])]): GridPane =
    val gridPane = new GridPane:
      hgap = 6
      vgap = 6
      padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
    
    var row = 0
    for ((label, spinner) <- controls)
      val columnLabel = new Label:
        alignment = Pos.CENTER_LEFT
        text = label
      gridPane.add(columnLabel, columnIndex = 0, rowIndex = row)
      gridPane.add(spinner, columnIndex = 1, rowIndex = row)
      row += 1

    gridPane