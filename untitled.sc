implicit val x: Double => Int = (d: Double) => d.toInt
//implicit def doubleToInt(x: Double): Int = x.toInt

val i: Int = 3.5343432
// Same as val i: Int = x(3.5343432)


def fibonacci(x: Long): Long = x match {
  case 0 => 0
  case 1 => 1
  case x => fibonacci(x-1) + fibonacci(x-2)
}

(1 to 50).map(_.toLong).map(fibonacci).take(10)





