package objektwerks

import java.time.LocalDateTime

import scalafx.beans.property.ObjectProperty

final case class Model(int: Int = 1,
                       double: Double = 1.1,
                       list: List[String] = List("abc", "def", "ghi"),
                       listItem: String = "abc",
                       datetime: LocalDateTime = LocalDateTime.now):
  val intProperty = ObjectProperty[Int](this, "int", int)
  val doubleProperty = ObjectProperty[Double](this, "double", double)
  val listProperty = ObjectProperty[List[String]](this, "list", list)
  val datetimeProperty = ObjectProperty[LocalDateTime](this, "datetime", datetime)