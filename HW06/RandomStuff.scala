/**
  * Created by halil on 23.12.2016.
  */
trait RandomStuffTrait {
  def transform(list: List[Int], op: (Int) => Int) : List[Int]
  def allValid(list: List[Int], op: (Int) => Boolean) : Boolean
  def executeWithRetry(retryCount: Int, op: => Int) : Option[Int]

}

object RandomStuff extends RandomStuffTrait{
  override def transform(list: List[Int], op: (Int) => Int) : List[Int] = {
    for(listElement <- list) yield op(listElement)
  }

  override def allValid(list: List[Int], op: (Int) => Boolean) ={
    var x = true
    for(listElement <- list){
      if(!op(listElement)) x = false
    }
    x
  }

  override def executeWithRetry(retryCount: Int, op: => Int) :Option[Int]=  {
    try {
      return Option(op)
    }
    catch {
      case ex : Throwable =>for(x <- 0 to retryCount)
      {
        try{return Option(op)}
        catch {case ex: Throwable => }
      }
    }
    return None
  }

}
