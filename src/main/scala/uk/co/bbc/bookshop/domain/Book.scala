package uk.co.bbc.bookshop.domain

import scala.util.{Failure, Success, Try}

trait Sales {
  var price: Price
  var salesPercentage: Double = 0.0
  def calcSalePrice() : Unit = {
    val difference: Price = (price / 100) * salesPercentage
    price = price - difference
  }
}

trait Print {
  self: Price =>
  def print() : Unit = println(this)
}

abstract class Product(val name: String, var price : Price, val publisher : Publisher, val genre : Genre)
  extends Sales {
  if ( price.value <= 0.0 ) throw new BookShopException("Price cannot be 0 or a negative number")
}

class Book(_name: String,
           _price: Price,
           // uk.co.bbc.bookshop.domain.Author only accepts Option type
           val author: Option[Author],
           _publisher: Publisher,
           _genre: Genre) extends Product(_name, _price, _publisher, _genre) {

  // Pulled from uk.co.bbc.bookshop.domain.Sales trait
  salesPercentage = 10.0
  calcSalePrice()

  override def toString() = f"($name, $price, ${author.getOrElse("Anonymous")}, \n$publisher, $genre)"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Book]

  override def equals(other: Any): Boolean = other match {
    case that: Book =>
        name == that.name &&
        price == that.price &&
        author == that.author &&
        publisher == that.publisher &&
        genre == that.genre
    case _ => false
  }

  override def hashCode(): Int = {
    name.hashCode() + price.hashCode() + author.hashCode() + publisher.hashCode()
  }
}

final case class Author(name: String)

final case class Address(number: Int, street: String, city: String, county: String, postcode: String)

final case class Publisher(name: String, address: Address)

final case class Price(value: Double) extends Print {
  def +(p: Double) : Price = Price(value + p)
  def -(p: Double) : Price = Price(value - p)
  def *(p: Double) : Price = Price(value * p)
  def /(p: Double) : Price = Price(value / p)

  def +(p: Price) : Price = Price(value + p.value)
  def -(p: Price) : Price = Price(value - p.value)
}
