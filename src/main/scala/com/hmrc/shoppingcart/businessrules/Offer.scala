package com.hmrc.shoppingcart.businessrules

import com.hmrc.shoppingcart.domain.Item
/**
  * This is business class for shopping cart application which has
  * different offer rule for different item.
  *
  * @author  Naresh Soni
  */
trait Offer {
  def applyOffer(items: List[Item]): Int
}

/**
  * This is default rule when no offer applies
  * in this case size of cart is actual size of items.
  */
object ActualPrice extends Offer {
  def applyOffer(items: List[Item]): Int = items.size
}

/**
  * Buy one get one free
  */
object BuyOneGetOneFree extends Offer {
  def applyOffer(items: List[Item]): Int = items.size / 2 + items.size % 2
}

/**
  * Three for the price of two
  */
object ThreeForTwoOffer extends Offer {
  def applyOffer(items: List[Item]): Int = (2 * (items.size / 3)) + items.size % 3
}
