ScalaFx Form
------------
>ScalaFx ***custom*** form layout with assorted ***custom*** controls prototype using Scala 3.

>Typically ```ModelForm``` would not be required; and, instead, be built directly in ```ModelDialog```.

>```ModelPane``` would not contain ```ModelForm```; and, instead, be built as ```ModelsPane```, listing ```Models```.

>Custom controls include:
* DateField
* DateTimeField
* DoubleTextField
* IntTextField
* NonEmptyTextField
* NumberSlider
* TimeField
> All custom controls are ***self-validating***!

>Standard controls include:
* CheckBox
* ChoiceBox
* CombonBox
* DatePicker
* ListView
>These standard controls are effectivelly ***self-validating***. **Warning**: Using a **SelectionModel** can return a **null** value!
Consequently, consider using a **ChangeListener**. See **ModePane** for examples.

Notes
-----
1. ```ToggleButton``` and ```RadioButton```, when wrapped in a ```ToggleGroup```, can't be added to a ```Form``` - not being a ```Node``` or subclass of ```Node```.

Model
-----
* Model 1 --> * ObjectProperty ( for each model field )
* Form 1 --> * Field 1 --> 1 (Label, Node)
* ModelForm 1 --> 1 Model, Form
* ModelPane 1 --> 1 ModelForm
* ModelDialog 1 --> 1 ModelForm
* MenuBar 1 --> 1 Menu 1 --> * MenuItem
* View 1 --> 1 Model, MenuBar, ModelPane
* App 1 --> 1 View

Build
-----
1. sbt clean compile

Run
---
1. sbt run

Resources
---------
* [ScalaFx](https://www.scalafx.org/)
* [JavaFx 21 Javadoc](https://openjfx.io/javadoc/21/)
* [Jenkov JavaFx](https://jenkov.com/tutorials/javafx/index.html)