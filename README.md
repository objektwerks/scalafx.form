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

Standard Controls
-----------------
>These controls are *effectivelly self-validating*.
* CheckBox
* ChoiceBox
* CombonBox
* DatePicker
* ListView

Notes
-----
1. Using a ```SelectionModel``` can return a ***null*** value! Consider using a ```ChangeListener```. See ```ModelForm``` for examples.
2. ```ToggleButton``` and ```RadioButton```, when wrapped in a ```ToggleGroup```, can't be added to a ```Form``` - not being a ```Node``` or subclass of ```Node```.
3. Don't make *custom* controls *final*.

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

ScalaFx Binding
---------------
* ScalaFx property binding for case class / properties / controls doesn't appear to work:
```
  case class Person(name: String):
    val nameProperty = ObjectProperty(name)
    nameProperty.bind( Bindings.createObjectBinding(() => this.name, nameProperty) )

  val labelName = Label( context.labelName )
  val textFieldName = new TextField():
    text <==> model.selectedPerson.value.nameProperty
```
>Simple ScalaFx property binding does work, though. Currently using manual case class / property binding.

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
