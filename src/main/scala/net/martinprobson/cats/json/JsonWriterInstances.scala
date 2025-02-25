package net.martinprobson.cats.json

object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] =
    (value: String) => JsString(value)

  implicit val personWriter: JsonWriter[Person] =
    (value: Person) => JsObject(Map(
      "name" -> JsString(value.name),
      "email" -> JsString(value.email)
    ))

  implicit val intWriter: JsonWriter[Int] =
    (value: Int) => JsNumber(value.toDouble)

  implicit val optionWriterInt: JsonWriter[Option[Int]] = {
    case Some(i) => JsNumber(i.toDouble)
    case None => JsNull
  }

  // Recursive search for implicits....
  implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] = {
    case Some(v) => writer.write(v)
    case None => JsNull
  }
}
