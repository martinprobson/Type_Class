package net.martinprobson.cats.json

// Define a very simple net.martinprobson.cats.json.Json AST
sealed trait Json

final case class JsObject(get: Map[String,Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json
case object JsNull extends Json


// This is our actual type class
object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
    w.write(value)
}
