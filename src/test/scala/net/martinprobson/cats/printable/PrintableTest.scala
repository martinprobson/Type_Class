package net.martinprobson.cats.printable

import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class PrintableTest extends FlatSpec with GeneratorDrivenPropertyChecks with Matchers {

  val ascii: Gen[String] = Gen.asciiPrintableStr

  "Printable.format" should "convert a String" in {
    import PrintableInstances.stringPrintable
    forAll(minSuccessful(100)) { s: String =>
      println(s"String = $s")
      Printable.format(s) should equal(s"Printable string: $s")
    }
  }

  "Printable.format" should "convert an ascii String" in {
    import PrintableInstances.stringPrintable
    forAll(ascii, minSuccessful(100)) { s: String =>
      println(s"String = $s")
      Printable.format(s) should equal(s"Printable string: $s")
    }
  }

  "Printable.format" should "convert an int" in {
    import PrintableInstances.intPrintable
    forAll(minSuccessful(100)) { i: Int =>
      println(i)
      Printable.format(i) should equal(s"Printable int: $i")
    }
  }
}
