package net.martinprobson.cats.json

object Main extends App {
  /* The object net.martinprobson.cats.json.Json has a method toJson that an implicit argument of
     type net.martinprobson.cats.json.JsonWriter[A]: -
        net.martinprobson.cats.json.Json.toJson(value: A)(implicit w :net.martinprobson.cats.json.JsonWriter[A])

      The compiler knows the type of A (net.martinprobson.cats.json.Person in this case), so it
      tries to find an implicit definition that matches the type signature: -

      net.martinprobson.cats.json.JsonWriter[net.martinprobson.cats.json.Person]

      and it finds one in the companion object of the trait net.martinprobson.cats.json.JsonWriter.

   */

  import JsonWriterInstances._

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

}
