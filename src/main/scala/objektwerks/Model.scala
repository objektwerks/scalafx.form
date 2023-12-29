package objektwerks

import java.time.LocalDateTime

final case class Model(int: Int,
                       double: Double,
                       list: List[String],
                       datetime: LocalDateTime = LocalDateTime.now)
