package uk.co.bbc.akka

import akka.actor._

case class HelloWorldMessage(id: Int, value: String)

class HelloWorldActor extends Actor {
  def receive: Receive = {
    case HelloWorldMessage(id, value) => for (_ <- 1 to 200) println(s"id: $id value: $value")
    case _ => println(s"Not Expected")
  }
}

object ActorApp extends App {
  println(s"Starting...")
  val system = ActorSystem("MyActorSystem")
  val helloWorldActorProperties = Props(new HelloWorldActor)
  val actorInstance1 = system.actorOf(helloWorldActorProperties)
  val actorInstance2 = system.actorOf(helloWorldActorProperties)
  val actorInstance3 = system.actorOf(helloWorldActorProperties)

  println(s"Sending messages...")
  actorInstance1 ! HelloWorldMessage(1, "Hello")
  actorInstance2 ! HelloWorldMessage(2, "Hallo")
  actorInstance3 ! HelloWorldMessage(3, "Hola")
  actorInstance1 ! HelloWorldMessage(4, "Howdy")

  println(s"About to terminate...")
  system.terminate()

  println(s"Finished")
}
