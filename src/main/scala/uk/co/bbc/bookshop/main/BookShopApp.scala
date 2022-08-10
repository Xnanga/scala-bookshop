package uk.co.bbc.bookshop.main

import uk.co.bbc.bookshop.domain.{Book, Technical}

object BookShopApp extends App {
  println("Welcome to the Bookshop")
  BookShop.printDetails()

  val prettyPrint = (book: Book) =>
    println(s"${book.name}\n\tby ${book.author.getOrElse("Anonymous")}\n\t\tat ${book.price}")

  val techBooks = BookShop.books.getOrElse(Technical, Nil)
  if (techBooks != Nil ) {
    val book = techBooks.head
    prettyPrint(book)
  }

  println(s"Done")
}
