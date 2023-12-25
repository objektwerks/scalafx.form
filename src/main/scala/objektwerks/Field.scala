package objektwerks

final case class Validator()

final case class Field(validator: Validator)

final case class Fields(fields: List[Field])