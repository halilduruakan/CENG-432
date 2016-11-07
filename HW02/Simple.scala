/**
  * Created by halil on 07.11.2016.
  */
object Simple extends App{

  val myList = Array(10,25,30)
  myList.foreach((i : Int ) => if(i % 2 == 0)println(2*i)else println(3*i))
}
