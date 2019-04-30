object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String] {
      def write(value: String): Json = JsString(value)
    }

  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      def write(value: Person): Json = JsObject(Map(
        "name" -> JsString(value.name),
        "email" -> JsString(value.email)
      ))
    }

  implicit val intWriter: JsonWriter[Int] =
    new JsonWriter[Int] {
      def write(value: Int): Json = JsNumber(value.toDouble)
    }
}
