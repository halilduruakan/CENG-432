
class IyteHashTable {
  val hashTableSize = 1000000;
  var arrayHashTable = Array.fill[IyteMutableList](hashTableSize )(IyteMutableList())

  def set(key:String, value:String):Unit={
    if(arrayHashTable(hashFunction(key)).contains(value) == null)
      arrayHashTable(hashFunction(key)).add(key,value)
  }

  def get(key:String):String={
    arrayHashTable(hashFunction(key)).contains(key)
  }
  def hashFunction(key: String):Int={
    var hashValue:Long = 0;
    for (ch <- key){
     hashValue = (hashValue*31+ ch)%hashTableSize;
    }
    hashValue.toInt
  }
}

object IyteHashTable {
  def apply(): IyteHashTable = new IyteHashTable()
}
