package uk.co.bbc.bookshop.server

import uk.co.bbc.bookshop.domain._

object BookShopRepository {
  private val author = Author("Pete Smith")
  private val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
  private val publisher = Publisher("Tech Books Publishing Ltd.", address)

  val technicalBooks = List(new Book("Scala Unleashed", Price(16.95), Some(author), publisher, Technical), new Book("Python in the Wild", Price(12.55), Some(Author("Joe Jones")), publisher, Technical))
  val historicalPublisher = Publisher("Historical Books Are Us", Address(5, "The Estate", "Market Town", "Hampshire", "HA3 4RR"))
  val historyBooks = List(new Book("The Wars of the Roses Retold", Price(12.34), Some(Author("Pete Andrews")), historicalPublisher, History))
  val fictionPublisher = Publisher("Adriana Books", Address(340, "Long Mile Road", "Swindon", "Wiltshire", "SN12 6ER"))
  val fictionBooks = List(new Book("It was a Dark Night", Price(23.55), Some(Author("Gryff Cooke")), fictionPublisher, Fiction))

  val allBooks = Map[Genre, List[Book]](
    Technical -> technicalBooks,
    History -> historyBooks,
    Fiction -> fictionBooks
  )

  def getBooks(): Map[Genre, List[Book]] = allBooks

  override def toString = s"BookShopRepository($author, $address, $publisher, $technicalBooks, $historicalPublisher, $historyBooks, $fictionPublisher, $fictionBooks, $allBooks)"
}
