ScalaFx Form
------------
>ScalaFx ***custom*** form layout and controls using Scala 3.

Custom Controls
---------------
> These controls are *self-validating*.
* DateField
* DateTimeField
* DoubleTextField
* IntTextField
* NonEmptyTextField
* NumberSlider
* TimeField
* ControlGrid
* LabelButton
* LabelRangeSlider

Standard Controls
-----------------
>These controls are *effectivelly self-validating*.
* CheckBox
* ChoiceBox
* CombonBox
* DatePicker
* ListView

Control Issues
--------------
1. Using a ```SelectionModel``` can return a ***null*** value! Consider using a ```ChangeListener```. See ```ModelForm``` for examples.
2. ```ToggleButton``` and ```RadioButton```, when wrapped in a ```ToggleGroup```, can't be added to a ```Form``` - not being a ```Node``` or subclass of ```Node```.

ScalaFx Binding
---------------
>A ScalaFx bidirectional binding between a control property and case class property works as expected.

>However, case class property changes are not reflected in linked case class fields.

>For instance, this case class:
```
final case class Person(name: String):
  val nameProperty = ObjectProperty[String](this, "name", name)
```
>with this UI model ( abbreviated here for clarity ):
```
final case class Model(person: Person):
  val personProperty = ObjectProperty[Person](this, "person", person)
```
>and this bidirectional binding:
```
val labelPersonName = Label("Person Name:" )
val textPersonName = new NonEmptyTextField():
  text <==> model.personProperty.value.nameProperty
```
>Note how the ```NonEmptyTextField.text``` property is bidirectionally bound with ```Person.nameProperty```
>via this symbol ```<==>```.

>Debug in ```ModelForm``` shows changes in ***both*** properties being bidirectionally reflected as expected.

>Debug in ```Model``` shows ```Person.nameProperty``` changes are ***never*** reflected in ```Person.name```.

>So, is creating case classes with ScalaFx properties the only solution? For instance:
```
final case class Person(name: ObjectProperty[String])
final case class Model(person: ObjectProperty[Person])
```
>or will this method suffice:
```
  def fromProperties: Model =
    Model(
      person = personProperty.value.copy(name = personProperty.value.nameProperty.value)
    )
```
>Note ***this*** line: ```person = personProperty.value.copy(name = personProperty.value.nameProperty.value)```,
>which yields a correctly updated ```Person``` instance.

>Or is this a better option:
```
final case class Person(name: String):
  val nameProperty = ObjectProperty[String](this, "name", name)

  def fromProperties: Person = Person( nameProperty.value )
```
>which would change the above ```Model``` line to: ```person = personProperty.value.fromProperties```

>Both approaches circumvent the case class ***field-not-being-updated*** issue --- while allowing case classes to be used naturally.

>See [Model](https://github.com/objektwerks/scalafx.form/blob/main/src/main/scala/objektwerks/Model.scala) and
[ModelForm](https://github.com/objektwerks/scalafx.form/blob/main/src/main/scala/objektwerks/ModelForm.scala)

Model
-----
* Model 1 --> * ObjectProperty ( for each model field )
* Form 1 --> * Field 1 --> 1 (Label, Node)
* ModelForm 1 --> 1 Model, Form
* ModelPane 1 --> 1 ModelForm
* ModelDialog 1 --> 1 ModelForm
* MenuBar 1 --> 1 Menu 1 --> * MenuItem ( dialog, exit )
* Menu 1 -- build --> 1 MenuBar ( custom menu builder )
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

Assembly
--------
1. sbt clean test assembly copyAssemblyJar

Execute
-------
1. java -jar .assembly/scalafx-speech-$version.jar ( or double-click executable jar )

Resources
---------
* [ScalaFx](https://www.scalafx.org/)
* [JavaFx 21 Javadoc](https://openjfx.io/javadoc/21/)
* [Jenkov JavaFx](https://jenkov.com/tutorials/javafx/index.html)

License
-------
>Copyright (c) [2024, 2025] [Objektwerks]

>Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    * http://www.apache.org/licenses/LICENSE-2.0

>Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.