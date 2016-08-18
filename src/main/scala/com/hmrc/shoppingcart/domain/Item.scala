package com.hmrc.shoppingcart.domain

/**
  * This is domain class for Item which has
  * price and types like Fruit, Toy etc.
  *
  * @author  Naresh Soni
  */
trait Item {
  def price: BigDecimal
  def itemType: String
}

/**
  * This is domain class for Apple which is
  * of type Fruit
  */
case class Apple(val price: BigDecimal = 0.60, val itemType: String = "Fruit") extends Item

/**
  * This is domain class for Orange which is
  * of type Fruit
  */
case class Orange(val price: BigDecimal = 0.25, val itemType: String = "Fruit") extends Item
