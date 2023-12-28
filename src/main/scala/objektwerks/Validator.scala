package objektwerks

trait Validator:
  def validate(): Boolean

final class DefaultValidator extends Validator:
  def validate(): Boolean = true