package net.martinprobson.cats.printable


object Main extends App {

  import PrintableInstances._

  Printable.print("Martin")
  Printable.print(10)
  println(Printable.format("Martin"))
  println(Printable.format(10))

}
