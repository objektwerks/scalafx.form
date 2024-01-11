ScalaFx Form
------------
>ScalaFx ***custom*** form layout - to include assorted ***custom*** controls - using Scala 3.

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
>These standard controls are effectivelly ***self-validating***.

Notes
-----
1. Using a **SelectionModel** can return a **null** value! Consider using a **ChangeListener**. See **ModelForm** for examples.
2. ```ToggleButton``` and ```RadioButton```, when wrapped in a ```ToggleGroup```, can't be added to a ```Form``` - not being a ```Node``` or subclass of ```Node```.
3. Don't make custom controls final!

Model
-----
* Model 1 --> * ObjectProperty ( for each model field )
* Form 1 --> * Field 1 --> 1 (Label, Node)
* ModelForm 1 --> 1 Model, Form
* ModelPane 1 --> 1 ModelForm
* ModelDialog 1 --> 1 ModelForm
* MenuBar 1 --> 1 Menu 1 --> * MenuItem ( dialog, exit )
* Menu 1 -- build --> MenuBar ( objektwerks menu object )
* View 1 --> 1 Model, MenuBar, ModelPane
* App 1 --> 1 Model, View

>Typically, a ```ModelForm``` would not be required. Instead, a ```Form``` would be built directly in a ```ModelDialog```.

>And a ```ModelPane``` would not contain a ```ModelForm```. Instead, it would contain a list of ```Models```.

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