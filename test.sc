abstract class A {
  var a: Option[Int] = None
  println(s"A $a")
}

object A {
  var aa: Option[Int] = None
}

import A._
class B extends A {
  a = Some(1)
  aa = Some(2)
  println(s"B $a")
}

class C extends A {
  println(s"C $a")
  println(s"aa $aa")
}

new B
new C


