/**
  * Created by halil on 12.11.2016.
  */
trait IyteImmutableList {
  def add(x: Int): IyteImmutableList
}

case object Nul extends IyteImmutableList {
  override def add(x: Int): IyteImmutableList = Node(x, Nul)
  override def toString: String = ""
}

case class Node(value: Int, next: IyteImmutableList) extends IyteImmutableList {
  override def add(x: Int): IyteImmutableList = Node(x, this)
  override def toString: String = {
    if(next==Nul){
      value.toString
    }
    else{
      value+","+next
    }
  }
}

object IyteImmutableList {
  def apply: IyteImmutableList = Nul
}