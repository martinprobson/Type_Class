
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

quickSort(List(3,2,11,1,1,1,1,1,1,100,56,3,2,1,4,5,5,5,5))

quickSort(List(Person1("Martin",54),
  Person1("Gemma",19),
  Person1("Natasha",16)))