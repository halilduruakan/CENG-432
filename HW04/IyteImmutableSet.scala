sealed abstract class IyteImmutableSet {
  def add(x: Int): IyteImmutableSet
  def toString: String
  def containts(x: Int):Boolean
}

class Hash(arrayHashTable: Array[IyteImmutableList]) extends IyteImmutableSet{
  val arrayHash : Array[IyteImmutableList] = arrayHashTable
  override def add(x: Int):IyteImmutableSet={
    val returnedArray : Array[IyteImmutableList] = new Array[IyteImmutableList](100)
    val y = (x%100)*((x+3)%100)%100
    Array.copy(arrayHash,0,returnedArray,0,100)
    if(!returnedArray(y).contains(x)){
      returnedArray(y) = returnedArray(y).add(x)
    }
    new Hash(returnedArray)
  }
  override def containts(x: Int): Boolean={val y = (x%100)*((x+3)%100)%100;arrayHash(y).contains(x)}
  override def toString():String={arrayHash.filter(list => !list.isNull).mkString(",")}

}

object IyteImmutableSet{
  def apply(): IyteImmutableSet = new Hash(Array.fill[IyteImmutableList](100)(IyteImmutableList()))
}
