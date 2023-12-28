package objektwerks

final case class Field(label: Label,
                       control: Region,
                       validator: Validator = DefaultValidator())