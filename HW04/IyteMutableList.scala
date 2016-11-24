class IyteMutableList {
  class Node (itemValue: Int, nextItem: Node ){
    val value = itemValue
    var next = nextItem
  }
  var start: Node = null
  var cache: Node = null

  def add(value:Int) {
    if(start == null){
      start = new Node(value,null)
      cache = start
    }
    else{
      cache.next = new Node(value, null)
      cache = cache.next


    }
  }

  override def toString() : String={
    var n = start;
    var listToString = ""
    while(n != null){
      listToString = listToString + n.value +","
      n = n.next
    }
    listToString.substring(0,listToString.length-1)
  }

  def contains(x:Int): Boolean ={
    var temp = start

    if (temp == null)  false
    while(temp != null){
      if(temp.value == x ) return true
      else temp = temp.next
    }
    false

  }
  def isNull() : Boolean= {
    start == null
  }
}
object IyteMutableList {

  def apply() = new IyteMutableList()

}
