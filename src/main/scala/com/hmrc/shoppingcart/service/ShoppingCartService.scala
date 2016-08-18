package com.hmrc.shoppingcart.service

import com.hmrc.shoppingcart.domain.Item

import scala.math.BigDecimal

/**
  * Created by moksha on 17/08/2016.
  */
trait ShoppingCartService {
  def checkoutCost(items: List[Item]): BigDecimal
}

class ShoppingCartServiceImpl extends ShoppingCartService {
  override def checkoutCost(items: List[Item]): BigDecimal = {
    items.map(_.price).sum
  }
}

