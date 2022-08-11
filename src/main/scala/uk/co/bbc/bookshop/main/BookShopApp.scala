package uk.co.bbc.bookshop.main

import uk.co.bbc.bookshop.domain._

object BookShopApp extends App {
  println("Welcome to the Bookshop")
  BookShop.printDetails()

  val prettyPrint = (book: Book) =>
    println(s"${book.name}\n\tby ${book.author.getOrElse("Anonymous")}\n\t\tat ${book.price}")

  val techBooks = BookShop.books.getOrElse(Technical, Nil)
  if (techBooks != Nil ) {
    println("All Discounted Tech Books")
    println("-" * 25)
    techBooks
      .filter(book => book.price.value < 15.00)
      .foreach(book => prettyPrint(book))
  }

  BookShop.applyToGenre(prettyPrint, Technical)

  // test exception handling
//  try {
//    val author = Author("Paul Lawton")
//    val address = Address(11, "Market Street", "Swindon", "Wiltshire", "SN10 5LD")
//    val publisher = Publisher("Tech Books Publishing Ltd.", address)
//    val book = new Book("Future Scala", Price(-5.95), Some(author), publisher, Technical)
//    println(book)
//  } catch {
//    case e: BookShopException =>
//      e.printStackTrace()
//      println("Caught the exception")
//  }

  println(s"Done")
}
