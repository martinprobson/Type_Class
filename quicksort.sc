
//def quickSort[A]()

List(1,2,3) match {
  case Nil => "Nil"
  case x :: Nil => "one"
  case x :: xs => "Many"
}

def quickSort[T](l: List[T])(implicit o: Ordering[T]):List[T] = l match {
  case Nil => Nil: List[T]
  case x :: xs => {
    quickSort(xs.filter(e => o.lteq(e,x))) ++
      List(x) ++
    quickSort(xs.filter(e => o.gt(e,x)))
  }
}

final case class Person1(name: String, age: Int)
implicit object AgeOrdering extends Ordering[Person1] {
  def compare(a: Person1, b: Person1) = a.age compareTo b.age
}
implicit object NameOrdering extends Ordering[Person1] {
  def compare(a: Person1, b: Person1) = a.name compareTo b.name
}

quickSort(List(3,2,11,1,1,1,1,1,1,100,56,3,2,1,4,5,5,5,5))

quickSort(List(Person1("Martin",54),
  Person1("Gemma",19),
  Person1("Natasha",16)))(NameOrdering)

def quickSort1[T](list: List[T])(implicit o: Ordering[T]): List[T] =
  list match {
    case Nil => Nil
    case (head :: tail) =>
      // select head as the pivot point
      val pivot = head
      val (lessThanPivot, greaterThanPivot) = tail.partition(e => o.lteq(pivot, e))
      quickSort1(lessThanPivot) ::: pivot :: quickSort1(greaterThanPivot)
  }

val p = add(1) _

add(1)(2)
val a = Some(1)
val l: Long = 2

a.getOrElse(3.toLong)

def add(a: Int)(b: Int) = a + b

p(2)