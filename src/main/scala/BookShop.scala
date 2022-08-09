object BookShop {
  val name = "Scala Books of the World"
  val address = new Address(26, "Main Street", "Bath", "BANES", "BA1 3ZZ")
  val book = setupBooks()

  def printDetails(): Unit = {
    println(s"Name: ${name}")
    println(s"Address: ${address}")
    println(s"Book: ${book}")
  }

  private def setupBooks(): Book = {
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val price = new Price(15.95)
    // Author is optional, can be passed Some(author) or None
    new Book("Scala Unleashed", price, Some(author), publisher, Technical)
  }

  override def toString() = s"BookShop($name, $address, $book)"
}