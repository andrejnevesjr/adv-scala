import scala.annotation.tailrec
object Recap extends App {
  val aCondition: Boolean = false
  val aConditionalVal = if (aCondition) 42 else 65

// compiler infers types for us
  val aCodeBlock = {
    if (aCondition) 54
    56
  }

  // unit = void
  val theUnit = println("Hello, Scala")

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion stack and tail
  @tailrec def factorial(n: Int, accumulator: Int = 1): Int =
    if (n <= 0) accumulator
    else factorial(n - 1, n * accumulator)

  println(factorial(5))

  // OOP
  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("Crunch")

  }

  // method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog

  // anonymus classes
  val aCarninove = new Carnivore {
    override def eat(a: Animal): Unit = println("Roar!")
  }

  // generics
  abstract class MyList[+A] // variance and variance problems

  // singleton and companions
  object MyList

  // case classes
  case class Person(name: String, age: Int)

  // exceptions and Try/Catch/Finally
  // val throwsException = throw new RuntimeException // Nothing
  // val aPotentialFailure =
  //   try {
  //     throw new RuntimeException
  //   } catch {
  //     case e: Exception => "I caught an exception"
  //   } finally {
  //     println("Some logs")
  //   }

  // package and imports

  // functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1

  }
  incrementer(1)

  val anonymusIncrementer = (x: Int) => x + 1

  List(1, 2, 3).map(anonymusIncrementer) // High order functions
  // map, flatmap, filter
  // for-comprehension
  val pairs = for {
    num <- List(1, 2, 3)
    char <- List("a", "b", "c")
  } yield num + " - " + char

  println(pairs)

  // Collections
  val aMap = Map(1 -> "André", 2 -> "João")

  // "Collections": Options, Try
  val anOption = Some(2)

  // pattern matching
  val x = 2
  val order = x match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => x + "th"
  }

  val bob = Person("BOb", 22)
  val greeting = bob match {
    case Person(n, _) => s"Hi my name is $n"
  }

  // all the patterns
  

}
