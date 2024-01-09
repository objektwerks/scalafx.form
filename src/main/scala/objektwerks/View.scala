package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.VBox
import scalafx.scene.control.{Menu, MenuBar, MenuItem, SeparatorMenuItem}

class View:
  val model = Model()

  val dialog = new MenuItem("Dailog"):
    onAction = { _ =>
      println(s"*** Model: ${model.propertiesToModel}")
    }

  val exit = new MenuItem("Exit"):
    onAction = { _ => System.exit(0) }

  val menu = new Menu("Menu"):
    items = List(dialog, SeparatorMenuItem(), exit)

  val menuBar = new MenuBar():
    menus = List(menu)

  val modelPane = ModelPane( ModelForm(model) )
  
  val contentPane = new VBox:
    spacing = 6
    padding = Insets(6)
    children = List(menuBar, modelPane)

  val scene = new Scene:
    root = contentPane
    stylesheets = List("/app.css")