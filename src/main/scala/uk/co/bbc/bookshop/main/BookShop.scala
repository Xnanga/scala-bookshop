package uk.co.bbc.bookshop.main

import uk.co.bbc.bookshop.domain._
import uk.co.bbc.bookshop.server.BookShopRepository

object BookShop {
  val name = "Scala Books of the World"
  val address = new Address(26, "Main Street", "Bath", "BANES", "BA1 3ZZ")
  //  val book = setupBooks()
  val books: Map[Genre, List[Book]] = BookShopRepository.getBooks()
  val today = DaysOfWeek.Wednesday

  def printDetails(): Unit = {
    println(s"Today is ${today}\n")
    println(s"Name: ${name}")
    println(s"Address: ${address}\n")
    println(s"Books: ${books}\n")
  }

  val applyToGenre = (func: Book => Unit, genre: Genre) => {
    val selectedBooks = books.getOrElse(genre, Nil)
    if (selectedBooks != Nil ) {
      println("All Books of One Genre")
      println("-" * 25)
      selectedBooks
        .foreach(book => func(book))
    }
  }

//  private def setupBooks(): Book = {
//    val author = Author("Pete Smith")
//    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
//    val publisher = Publisher("Tech Books Publishing Ltd.", address)
//    val price = new Price(15.95)
//    uk.co.bbc.bookshop.domain.Author is optional, can be passed Some(author) or None
//    new Book("Scala Unleashed", price, Some(author), publisher, Technical)
//  }

  // Available via uk.co.bbc.bookshop.domain.Print trait mixed into uk.co.bbc.bookshop.domain.Price
  //  BookShop.book.price.print()

  override def toString() = s"BookShop($name, $address, $books)"
}
