package objektwerks

import scalafx.scene.control.{Menu, MenuBar, MenuItem, SeparatorMenuItem}

object Menu:
  def build(model: Model): MenuBar =
    val loginRegisterMenuItem = new MenuItem("Login ~ Register"):
      onAction = { _ =>
        LoginRegisterDialog( App.stage, "Login ~ Register" ).showAndWait() match
          case Some(loginRegister: LoginRegister) => println(s"*** Login ~ Register: $loginRegister")
          case _ =>
      }

    val dialogMenuItem = new MenuItem("Dialog"):
      onAction = { _ =>
        ModelDialog( ModelForm(model) ).showAndWait() match
          case Some(edited: Model) => println(s"*** Model Dialog: ${edited.fromProperties}")
          case _ =>
      }

    val exitMenuItem = new MenuItem("Exit"):
      onAction = { _ => System.exit(0) }

    val menu = new Menu("Menu"):
      items = List(loginRegisterMenuItem, dialogMenuItem, SeparatorMenuItem(), exitMenuItem)

    new MenuBar():
      menus = List(menu)