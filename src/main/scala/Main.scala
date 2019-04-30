import JsonWriterInstances._

object Main extends App {
  var res = Json.toJson(Person("Martin", "martin@fred.co.uk"))
  println(res)
  res = Json.toJson("Fred")
  println(res)
  res = Json.toJson(10)
  println(res)


}
