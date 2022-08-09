trait Sales {
  var price: Price
  var salesPercentage: Double = 0.0
  def calcSalePrice() : Unit = {
    val difference: Price = (price / 100) * salesPercentage
    price - difference
  }
}

abstract class Product(val name: String, var price : Price, val publisher : Publisher, val genre : Genre)
  extends Sales

class Book(_name: String,
           _price: Price,
           // Author only accepts Option type
           val author: Option[Author],
           _publisher: Publisher,
           _genre: Genre) extends Product(_name, _price, _publisher, _genre) {

  // Pulled from Sales trait
  salesPercentage = 10.0
  calcSalePrice()

  // Pulls the author name from Option container, or "Anonymous" if None (empty container)
  val authorName = author.getOrElse("Anonymous")

  override def toString() = f"Book($name, $price, $authorName, \n$publisher, $genre)"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Book]

  override def equals(other: Any): Boolean = other match {
    case that: Book =>
        name == that.name &&
        price == that.price &&
        author == that.author &&
        publisher == that.publisher
    case _ => false
  }

  override def hashCode(): Int = {
    name.hashCode() + price.hashCode() + author.hashCode() + publisher.hashCode()
  }
}

final case class Author(name: String)

final case class Address(number: Int, street: String, city: String, county: String, postcode: String)

final case class Publisher(name: String, address: Address)

case class Price(value: Double) {
  def +(p: Double) : Price = Price(value + p)
  def -(p: Double) : Price = Price(value - p)
  def *(p: Double) : Price = Price(value * p)
  def /(p: Double) : Price = Price(value / p)

  def +(p: Price) : Price = Price(value + p.value)
  def -(p: Price) : Price = Price(value - p.value)
}
