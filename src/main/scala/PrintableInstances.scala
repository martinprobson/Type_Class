object PrintableInstances {
  implicit val stringPrintable: Printable[String] =
    (value: String) => s"Printable string: $value"

  implicit val intPrintable: Printable[Int] =
    (value: Int) => s"Printable int: $value"
}
