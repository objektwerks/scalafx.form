package objektwerks

import java.time.{LocalDateTime, LocalTime}

import scalafx.beans.property.ObjectProperty

final case class Model(text: String = "nonempty",
                       int: Int = 5,
                       double: Double = 5.5,
                       intRange: Range = Range(0, 10).inclusive,
                       intRangeValue: Int = 5,
                       doubleRange: Range = Range(0, 10).inclusive,
                       doubleRangeValue: Double = 5.5,
                       items: List[String] = List("abc", "def", "ghi"),
                       item: String = "abc",
                       isSelected: Boolean = true,
                       time: LocalTime = LocalTime.now,
                       datetime: LocalDateTime = LocalDateTime.now):
  val textProperty = ObjectProperty[String](this, "text", text)
  val intProperty = ObjectProperty[Int](this, "int", int)
  val doubleProperty = ObjectProperty[Double](this, "double", double)
  val intRangeValueProperty = ObjectProperty[Int](this, "intRangeValue", intRangeValue)
  val doubleRangeValueProperty = ObjectProperty[Double](this, "doubleRangeValue", doubleRangeValue)
  val listItemProperty = ObjectProperty[String](this, "listItem", item)
  val isSelectedProperty = ObjectProperty[Boolean](this, "isSelected", isSelected)
  val timeProperty = ObjectProperty[LocalTime](this, "time", time)
  val datetimeProperty = ObjectProperty[LocalDateTime](this, "datetime", datetime)

  def propertiesToModel: Model =
    Model(
      text = textProperty.value,
      int = intProperty.value,
      double = doubleProperty.value,
      intRangeValue = intRangeValueProperty.value,
      doubleRangeValue = doubleRangeValueProperty.value,
      items = items,
      item = listItemProperty.value,
      isSelected = isSelectedProperty.value,
      time = timeProperty.value,
      datetime = datetimeProperty.value
    )