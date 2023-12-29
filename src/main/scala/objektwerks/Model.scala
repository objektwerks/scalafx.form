package objektwerks

import java.time.LocalDateTime

final case class Model(int: Int = 1,
                       double: Double = 1.1,
                       list: List[String] = List("abc", "def", "ghi"),
                       datetime: LocalDateTime = LocalDateTime.now)
