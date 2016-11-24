  sealed abstract class IyteImmutableList {
  def add(x: Int): IyteImmutableList
  def contains(x: Int):Boolean
  def isNull():Boolean
}

 object Nul extends IyteImmutableList {
  override def add(x: Int): IyteImmutableList = new Node(x, Nul)
  override def toString: String = ""
  override def contains(x: Int): Boolean = false
  override def isNull():Boolean= true
}

case class Node(value: Int, next: IyteImmutableList) extends IyteImmutableList {
  override def add(x: Int): IyteImmutableList =new Node(x, this)
  override def toString: String = {
    next match {
      case Nul => value.toString
      case _ => value + "," + next
    }
  }
  override def contains(x: Int): Boolean = {
    def nextNode(x: Int, next: IyteImmutableList): Boolean = {
      next match {
        case Node(value, nn) => if (value == x) true else nextNode(x, nn)
        case Nul => false
      }
    }
    nextNode(x, this)
  }

  override def isNull():Boolean= false
}

object IyteImmutableList {
  def apply(): IyteImmutableList = Nul
}
