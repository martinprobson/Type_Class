sealed trait Tree[+A]

case object EmptyTree extends Tree[Nothing]

case class Node[+A](a: A, l: Tree[A], r: Tree[A]) extends Tree[A]

object Tree {
  def add[A](a: A, t: Tree[A])(implicit o: Ordering[A]): Tree[A] = t match {
    case EmptyTree => Node(a,EmptyTree,EmptyTree)
    case Node(y,left,right) => if (o.lteq(a,y))
      Node(y, add(a,left), right) else
      Node(y,left,add(a,right))
  }
}

List(5,3,7,1,4,6,8).reverse.foldRight(EmptyTree: Tree[Int])(Tree.add)
Range(1,1000).toList.foldRight(EmptyTree: Tree[Int])(Tree.add)
