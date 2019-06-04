//
// doRead       read
// doWrite      write
// doTransform  transform
//
import scala.util.{Success, Try}

type DataFrame = String
val c: DataFrameReader = ReadDataFrame

abstract class DataFrameReader {
  val doRead: Try[DataFrame] = {
    println("DataFrameReader.doRead")
    println("Doing read")
    val r = read
    println("Done read")
    r
  }

  def read: Try[DataFrame]
}

object ReadDataFrame extends DataFrameReader {
  override def read = Success("Martin")
}

c.doRead
