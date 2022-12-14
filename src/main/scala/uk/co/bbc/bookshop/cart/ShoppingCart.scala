package uk.co.bbc.bookshop.cart

import scala.collection.mutable.ListBuffer
import uk.co.bbc.bookshop.domain.Product

class ShoppingCart {
  val contents: ListBuffer[Product] = ListBuffer[Product]()
  def add(product: Product): Unit = {
    contents.addOne(product)
  }
  def remove(product: Product): Unit = {
    val index = contents.indexOf(product)
    if (index != -1) {
      contents.remove(index, 1)
    }
  }
  def isEmpty(): Boolean = {
    contents.isEmpty
  }
  def size(): Int = {
    contents.size
  }
  def total(): Double = {
    contents.foldLeft(0.0){(total, p) => total + p.price.value}
  }
}
