package objektwerks

import java.awt.Toolkit

import scalafx.scene.control.{Dialog, Label, TextField, Tab, TabPane}
import scalafx.scene.image.ImageView
import scalafx.stage.Stage

final case class Login(emailAddress: String, pin: String)
final case class Register(emailAddress: String)
final case class LoginRegister(login: Option[Login], register: Option[Register])

final class LoginRegisterDialog(stage: Stage,
                                title: String,
                                headerText: String,
                                graphic: ImageView) extends Dialog:
  initOwner(stage)
  title = title
  headerText = headerText
  graphic = graphic
  x = Toolkit.getDefaultToolkit.getScreenSize.width / 2.4
  y = Toolkit.getDefaultToolkit.getScreenSize.height / 6

  val loginEmailAddressTextField = TextField()
  val loginPasswordTextField = TextField()
  val loginControls = List(
    Label("Email Address:") -> loginEmailAddressTextField,
    Label("Password:") -> loginPasswordTextField
  )
  val loginCongrolGrid = ControlGrid(loginControls)

  val registerEmailAddressTextField = TextField()
  val registerControls = List(
    Label("Email Address:") -> registerEmailAddressTextField
  )
  val registerCongrolGrid = ControlGrid(registerControls)

  val loginTab = new Tab:
    text = "Login"
    closable = false
    content = loginCongrolGrid

  val registerTab = new Tab:
    text = "Register"
    closable = false
    content = registerCongrolGrid

  val tabPane = new TabPane:
    tabs = List(loginTab, registerTab)