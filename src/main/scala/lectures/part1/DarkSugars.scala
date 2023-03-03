package lectures.part1

import scala.util.Try

object DarkSugars extends App {
  // syntax sugar
  // #1 - methods with single parameter
  def singleArgumentMethod(arg: Int): String = s"$arg little ducks.."
  val description = singleArgumentMethod { 1 }

  val aTryInstance = Try {
    throw new RuntimeException
  }

  List(1, 2, 3).map { _ + 1 }.foreach(println)

  // #2 - Single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFunkyInstance: Action = (x: Int) => x + 1
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Hello, Scala")
  })

  val aSweeterThread = new Thread(() => println("sweet, scala"))

  abstract class anAbstractType {
    def implemented: Int = 23
    def f(a: Int): Unit
  }
  val anAbstractInstance: anAbstractType = (a: Int) => println("sweet")

  // #3 - the :: and #:: methods are special  (right associative)
  val prependList = 2 :: List(3, 4)

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this
  }
  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

  // #4 - multi word method naming
  class TeenGirl(name: String) {
    def `and then said`(gossip: String): Unit = println(s"$name said $gossip")
  }

  val lilly = new TeenGirl("Lilly")
  lilly `and then said` "Scala is so sweet"

  // #5 - infix types
  class Composite[A, B]
  val composite: Int Composite String = ???

  class -->[A, B]
  val towards: Int --> String = ???

  // #6  - update() is very special, much like apply()
  val anArray = Array(1, 2, 3)
  anArray(2) = 7 // rewritten to an anArray.update(2,7)
  // used in mutable collections

  // #7 - setters for mutable containers
  class Mutable {
    private var internalMember: Int = 0 // private for oo encapsulation

    def member: Int = internalMember // getter
    def member_=(value: Int): Unit = // setter
      internalMember = value

  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // possible only if set get and set on class

}
