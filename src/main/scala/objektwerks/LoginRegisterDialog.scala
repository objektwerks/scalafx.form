package objektwerks

import java.awt.Toolkit

import scalafx.scene.control.Dialog
import scalafx.scene.image.ImageView
import scalafx.stage.Stage

final case class Login(emailAddress: String, pin: String)
final case class Register(emailAddress: String)
final case class LoginRegister(login: Option[Login], register: Option[Register])

class LoginRegisterDialog(stage: Stage,
                          title: String,
                          headerText: String,
                          graphic: ImageView) extends Dialog:
  initOwner(stage)
  title = title
  headerText = headerText
  graphic = graphic
  x = Toolkit.getDefaultToolkit.getScreenSize.width / 2.4
  y = Toolkit.getDefaultToolkit.getScreenSize.height / 6