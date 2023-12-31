package objektwerks

import java.time.LocalDateTime

import scalafx.beans.property.ObjectProperty

final case class Model(int: Int = 5,
                       double: Double = 5.5,
                       intRange: Range = Range(1, 10).inclusive,
                       intRangeValue: Int = 5,
                       doubleRange: Range = Range(1, 10).inclusive,
                       doubleRangeValue: Double = 5.5,
                       list: List[String] = List("abc", "def", "ghi"),
                       listItem: String = "abc",
                       isSelected: Boolean = true,
                       datetime: LocalDateTime = LocalDateTime.now):
  val intProperty = ObjectProperty[Int](this, "int", int)
  val doubleProperty = ObjectProperty[Double](this, "double", double)
  val intRangeValueProperty = ObjectProperty[Int](this, "intRangeValue", intRangeValue)
  val doubleRangeValueProperty = ObjectProperty[Double](this, "doubleRangeValue", doubleRangeValue)
  val listItemProperty = ObjectProperty[String](this, "listItem", listItem)
  val isSelectedProperty = ObjectProperty[Boolean](this, "isSelected", isSelected)
  val datetimeProperty = ObjectProperty[LocalDateTime](this, "datetime", datetime)

  def propertiesToModel: Model =
    Model(
      int = intProperty.value,
      double = doubleProperty.value,
      intRangeValue = intRangeValueProperty.value,
      doubleRangeValue = doubleRangeValueProperty.value,
      list = list,
      listItem = listItemProperty.value,
      isSelected = isSelectedProperty.value,
      datetime = datetimeProperty.value
    )