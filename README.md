ScalaFx Form
------------
>ScalaFx form layout and associated controls prototype using Scala 3.

Model
-----
* Form 1 --> * Field 1 --> 1 (Label, Region)
* Model 1 --> * ObjectProperty
* ModelView 1 --> 1 Model, Form
* ModelView 1 --> * Control
* View 1 --> 1 ModelView ( typically with additional named views )
* App 1 --> 1 View

Build
-----
1. sbt clean compile

Run
---
1. sbt clean run