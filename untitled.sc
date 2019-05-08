import scala.reflect.ClassTag

implicit val x: Double => Int = (d: Double) => d.toInt
//implicit def doubleToInt(x: Double): Int = x.toInt

val i: Int = 3.5343432
// Same as val i: Int = x(3.5343432)

// Type erasure
object Extractor {
  def extract[T](l: List[Any])(implicit tag : ClassTag[T]) =
    l.flatMap{
      case e: T => Some(e)
      case _ => None
    }
}

Extractor.extract[String](List("a",1,2,3,4,"ZZZ",'c'))
def fibonacci(x: Long): Long = x match {
  case 0 => 0
  case 1 => 1
  case x => fibonacci(x-1) + fibonacci(x-2)
}

(1 to 50).map(_.toLong).map(fibonacci).take(10)





