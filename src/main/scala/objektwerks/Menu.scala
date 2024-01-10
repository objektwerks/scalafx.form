package objektwerks

import scalafx.scene.control.{Menu, MenuBar, MenuItem, SeparatorMenuItem}

object Menu:
  def build(model: Model): MenuBar =
    val dialogMenuItem = new MenuItem("Dialog"):
      onAction = { _ =>
        ModelDialog( ModelForm(model) ).showAndWait() match
          case Some(edited: Model) => println(s"*** Model Dialog: ${edited.propertiesToModel}")
          case _ =>
      }

    val exitMenuItem = new MenuItem("Exit"):
      onAction = { _ => System.exit(0) }

    val menu = new Menu("Menu"):
      items = List(dialogMenuItem, SeparatorMenuItem(), exitMenuItem)

    new MenuBar():
      menus = List(menu)