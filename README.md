ScalaFx Form
------------
>ScalaFx ***custom*** form layout with assorted ***custom*** controls prototype using Scala 3.

>Custom controls include:
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
* RadioButton ( ToggleGroup is not a Node! )
>These standard controls are effectivelly ***self-validating***. **Warning**: Using a **SelectionModel** can return a **null** value!
Consequently, consider using a **ChangeListener**. See **ModelView** for examples.

Model
-----
* Form 1 --> * Field 1 --> 1 (Label, Node)
* Model 1 --> * ObjectProperty ( for each model field )
* ModelView 1 --> 1 Model, Form
* ModelView 1 --> * Control
* View 1 --> 1 ModelView ( typically mutliple named views )
* App 1 --> 1 View

Build
-----
1. sbt clean compile

Run
---
1. sbt run

Resources
---------
* [Jenkov JavaFx](https://jenkov.com/tutorials/javafx/index.html)