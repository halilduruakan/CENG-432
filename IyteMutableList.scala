class IyteMutableList {
  class Node (keyValue:String, itemValue:String , nextItem: Node ){
    val value = itemValue
    val key = keyValue
    var next = nextItem
  }
  var start: Node = null
  var cache: Node = null

  def add(key:String, value:String) {
    if(start == null){
      start = new Node(key,value,null)
      cache = start
    }
    else{
      cache.next = new Node(key,value, null)
      cache = cache.next
    }
  }

  def contains(x:String): String={
    var temp = start
    if (temp == null) null
    while(temp != null){
      if(temp.key == x ) return temp.value
      else temp = temp.next
    }
   null
  }

}
object IyteMutableList {

  def apply() = new IyteMutableList()

}
