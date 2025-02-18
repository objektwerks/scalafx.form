package objektwerks

import java.time.{LocalDate, LocalDateTime, LocalTime}

import scalafx.beans.property.ObjectProperty

final case class Person(name: String):
  val nameProperty = ObjectProperty[String](this, "name", name)

final case class Model(text: String = "nonempty",
                       int: Int = 5,
                       double: Double = 5.5,
                       intRange: Range = Range(0, 10).inclusive,
                       intRangeValue: Int = 5,
                       doubleRange: Range = Range(0, 10).inclusive,
                       doubleRangeValue: Double = 5.5,
                       isChecked: Boolean = true,
                       items: List[String] = List("abc", "def", "ghi"),
                       item: String = "abc",
                       date: LocalDate = LocalDate.now,
                       time: LocalTime = LocalTime.now,
                       datetime: LocalDateTime = LocalDateTime.now,
                       person: Person = Person("Fred Flintstone")):
  val textProperty = ObjectProperty[String](this, "text", text)
  val intProperty = ObjectProperty[Int](this, "int", int)
  val doubleProperty = ObjectProperty[Double](this, "double", double)
  val intRangeValueProperty = ObjectProperty[Int](this, "intRangeValue", intRangeValue)
  val doubleRangeValueProperty = ObjectProperty[Double](this, "doubleRangeValue", doubleRangeValue)
  val isCheckedProperty = ObjectProperty[Boolean](this, "isChecked", isChecked)
  val itemProperty = ObjectProperty[String](this, "listItem", item)
  val dateProperty = ObjectProperty[LocalDate](this, "date", date)
  val timeProperty = ObjectProperty[LocalTime](this, "time", time)
  val datetimeProperty = ObjectProperty[LocalDateTime](this, "datetime", datetime)
  val personProperty = ObjectProperty[Person](this, "person", person)

  def propertiesToModel: Model =
    println(s"*** model person property: ${personProperty.value}")
    println(s"*** model person property name: ${personProperty.value.name}")
    println(s"*** model person property name property: ${personProperty.value.nameProperty.value}")
    Model(
      text = textProperty.value,
      int = intProperty.value,
      double = doubleProperty.value,
      intRangeValue = intRangeValueProperty.value,
      doubleRangeValue = doubleRangeValueProperty.value,
      isChecked = isCheckedProperty.value,
      items = items,
      item = itemProperty.value,
      date = dateProperty.value,
      time = timeProperty.value,
      datetime = datetimeProperty.value,
      person = personProperty.value
    )