package objektwerks

import java.awt.Toolkit

import scalafx.Includes.*
import scalafx.scene.control.{ButtonType, Dialog, Label, TextField, Tab, TabPane}
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.stage.Stage

import Validator.*

final case class Login(emailAddress: String, Pin: String)
final case class Register(emailAddress: String)
final case class LoginRegister(login: Option[Login] = None, register: Option[Register] = None)

final class LoginRegisterDialog(stage: Stage, title: String) extends Dialog[LoginRegister]:
  initOwner(stage)
  title = title
  x = Toolkit.getDefaultToolkit.getScreenSize.width / 2.4
  y = Toolkit.getDefaultToolkit.getScreenSize.height / 6

  val loginEmailAddressTextField = TextField()
  val loginPinTextField = TextField()
  val loginControls = List(
    Label("Email Address:") -> loginEmailAddressTextField,
    Label("Pin:") -> loginPinTextField
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

  dialogPane().content = tabPane

  val loginButtonType = new ButtonType("Login", ButtonData.Left)
  val registerButtonType = new ButtonType("Register", ButtonData.Right)
  dialogPane().buttonTypes = List(registerButtonType, loginButtonType)

  val loginButton = dialogPane().lookupButton(loginButtonType)
  loginButton.disable = true

  val registerButton = dialogPane().lookupButton(registerButtonType)
  registerButton.disable = true

  loginEmailAddressTextField.text.onChange { (_, _, newValue) =>
    loginButton.disable = !newValue.isEmailAddress && !loginPinTextField.text.value.isPin
  }

  loginPinTextField.text.onChange { (_, _, newValue) =>
    loginButton.disable = !newValue.isPin && !loginEmailAddressTextField.text.value.isEmailAddress
  }

  registerEmailAddressTextField.text.onChange { (_, _, newValue) =>
    registerButton.disable = !newValue.isEmailAddress
  }

  resultConverter = dialogButton =>
    if dialogButton == loginButtonType then
      LoginRegister(
        login = Some(
          Login(
            loginEmailAddressTextField.text.value,
            loginPinTextField.text.value
          )
        )
      )
    else if dialogButton == registerButtonType then
      LoginRegister(
        register = Some(
          Register(
            registerEmailAddressTextField.text.value
          )
        )
      )
    else null