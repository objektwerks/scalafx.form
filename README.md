ScalaFx Form
------------
>ScalaFx form component using Scala 3.

Todo
----
1. Fix NonEmptyTextField.

Model
-----
* Form 1 --> * Field 1 --> 1 (Label, Region)
* Model 1 --> * ObjectProperty[T]
* ModelView 1 --> 1 Model, Form
* ModelView 1 --> * Control

Build
-----
1. sbt clean compile

Run
---
1. sbt clean run