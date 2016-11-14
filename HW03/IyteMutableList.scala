/**
  * Created by halil on 12.11.2016.
  */
class IyteMutableList {
  class Node (itemValue: Int, nextItem: Node ){
    val value = itemValue
    var next = nextItem
  }
  var start: Node =null
  var cache:Node =start

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
}

object IyteMutableList {

  def apply() = new IyteMutableList()

}


