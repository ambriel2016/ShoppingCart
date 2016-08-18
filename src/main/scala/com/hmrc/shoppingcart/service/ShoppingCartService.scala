package com.hmrc.shoppingcart.service

import com.hmrc.shoppingcart.businessrules.{ActualPrice, Offer}
import com.hmrc.shoppingcart.domain.{Orange, Apple, Item}

import scala.math.BigDecimal

/**
  * Created by moksha on 17/08/2016.
  */
trait ShoppingCartService {
  def checkoutCost(items: List[Item], itemsOffer: Map[Item, Offer]): BigDecimal
}

class ShoppingCartServiceImpl extends ShoppingCartService {
  def checkoutCost(items: List[Item], itemsOffer: Map[Item, Offer]): BigDecimal = {
    items.groupBy(identity)
      .map({ case (item, listOfItems) => item.price * itemsOffer(item).applyOffer(listOfItems) })
      .sum
  }
}

