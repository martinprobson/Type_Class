package net.martinprobson.cats.printable

/* This is a type class */
trait Printable[A] {
  def format(value: A): String
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

  def print[A](value: A)(implicit p: Printable[A]): Unit =
    println(p.format(value))

}
