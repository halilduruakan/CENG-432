class IyteMutableSet {
  var arrayRange = 100
  var arrayHashTable = Array.fill[IyteMutableList](arrayRange)(IyteMutableList())



  def add(x:Int): Unit ={
    var k = (x%100)*((x+3)%100)%100
    if(!arrayHashTable(k).contains(x))
      arrayHashTable(k).add(x)
  }

  def contains(x:Int):Boolean={
    val y = (x%100)*((x+3)%100)%100
    arrayHashTable(y).contains(x)
  }

  override def toString:String={

    arrayHashTable.filter(list => !list.isNull()).mkString(",")

  }
}

object IyteMutableSet{
  def apply(): IyteMutableSet = new IyteMutableSet()
}
