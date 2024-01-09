package objektwerks

import scalafx.scene.control.Dialog

class ModelDialog(form: ModelForm) extends Dialog[Model]:
  initOwner(App.stage)
  title = "Model"
  headerText = "Model"