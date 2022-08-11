package uk.co.bbc.bookshop.cart

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funspec.AnyFunSpec
import uk.co.bbc.bookshop.domain._

import scala.collection.mutable.ListBuffer

class ShoppingCartTest extends AnyFunSpec with BeforeAndAfterEach {

  var shoppingCart: ShoppingCart = null

  // Figure out why this beforeEach() is not working as expected
//  override protected def beforeEach(): Unit = {
//    val author = Author("Pete Smith")
//    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
//    val publisher = Publisher("Tech Books Publishing Ltd.", address)
//    val newBook = new Book("Scala Unleashed", Price(15.00), Some(author), publisher, Technical)
//    shoppingCart = new ShoppingCart()
//  }

  describe("The ShoppingCart class") {
    describe("contents value") {
      val author = Author("Pete Smith")
      val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
      val publisher = Publisher("Tech Books Publishing Ltd.", address)
      val newBook = new Book("Scala Unleashed", Price(15.00), Some(author), publisher, Technical)
      shoppingCart = new ShoppingCart()
      it("should be empty") {
        assert(shoppingCart.contents.size == 0)
      }
    }

    describe("add method") {
      val author = Author("Pete Smith")
      val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
      val publisher = Publisher("Tech Books Publishing Ltd.", address)
      val newBook = new Book("Scala Unleashed", Price(15.00), Some(author), publisher, Technical)
      shoppingCart = new ShoppingCart()
      it("should increase the size of contents by one") {
        shoppingCart.add(newBook)
        assert(shoppingCart.contents.size == 1)
      }
    }
  }
}
