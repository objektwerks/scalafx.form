package objektwerks

object Validator:
  extension (value: String)
    def isPin: Boolean = value.length == 7
    def isEmailAddress: Boolean = value.nonEmpty && value.length >= 3 && value.contains("@")
    def isInt: Boolean = value.matches("\\d+")
    def isDouble: Boolean = value.matches("\\d{0,7}([\\.]\\d{0,4})?")