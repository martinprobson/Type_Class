import JsonWriterInstances._
import PrintableInstances._

object Main extends App {
  /* The object Json has a method toJson that an implicit argument of
     type JsonWriter[A]: -
        Json.toJson(value: A)(implicit w :JsonWriter[A])

      The compiler knows the type of A (Person in this case), so it
      tries to find an implicit definition that matches the type signature: -

      JsonWriter[Person]

      and it finds one in the companion object of the trait JsonWriter.

   */
  var res = Json.toJson(Person("Martin", "martin@fred.co.uk"))
  println(res)
  res = Json.toJson("Fred")
  println(res)
  res = Json.toJson(10)
  println(res)
  res = Json.toJson(Option(100))
  println(res)
  res = Json.toJson(Option.empty[Int])
  println(res)

  res = Json.toJson(Option("String"))
  println(res)
  res = Json.toJson(Option.empty[String])
  println(res)

  Printable.print("Martin")
  Printable.print(10)
  println(Printable.format("Martin"))
  println(Printable.format(10))
}
