package com.hmrc.shoppingcart.service

/**
  * Created by Naresh on 17/08/2016.
  */

import com.hmrc.shoppingcart.domain.{Orange, Apple}
import com.hmrc.shoppingcart.service.{ShoppingCartServiceImpl, ShoppingCartService}
import org.scalatest.{FlatSpec, Matchers}

class ShoppingCartServiceImplTest extends FlatSpec with Matchers {
  private val shoppingCart: ShoppingCartService = new ShoppingCartServiceImpl

  "An empty shopping cart " should "have a checkout cost of £0.00" in {
    assert(shoppingCart.checkoutCost(List()) == 0.00)
  }

  "A shopping cart with 1 Apple " should "have a checkout cost of £0.60" in {
    assert(shoppingCart.checkoutCost(List(new Apple)) == 0.60)
  }

  "A shopping cart with 2 Apples " should "have a checkout cost of £0.60" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple)) == 1.20)
  }

  "A shopping cart with 3 Apples " should "have a checkout cost of £1.20" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Apple)) == 1.80)
  }

  "A shopping cart with 4 Apples " should "have a checkout cost of £1.20" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Apple, new Apple)) == 2.40)
  }

  "A shopping cart with 1 Orange " should "have a checkout cost of £0.25" in {
    assert(shoppingCart.checkoutCost(List(new Orange)) == 0.25)
  }

  "A shopping cart with 2 Oranges " should "have a checkout cost of £0.50" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange)) == 0.50)
  }

  "A shopping cart with 3 Oranges " should "have a checkout cost of £0.50" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange, new Orange)) == 0.75)
  }

  "A shopping cart with 4 Oranges " should "have a checkout cost of £0.75" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange, new Orange, new Orange)) == 1.00)
  }

  "A shopping cart with 1 Apple, 1 Orange " should "have a checkout cost of £0.85" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange)) == 0.85)
  }

  "A shopping cart with 2 Apples, 1 Orange " should "have a checkout cost of £0.85" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple)) == 1.45)
  }

  "A shopping cart with 2 Apples, 2 Oranges " should "have a checkout cost of £1.10" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange)) == 1.70)
  }

  "A shopping cart with 3 Apples, 1 Orange " should "have a checkout cost of £1.45" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Orange, new Apple)) == 2.05)
  }

  "A shopping cart with 3 Apples, 2 Oranges " should "have a checkout cost of £1.70" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange, new Apple)) == 2.30)
  }

  "A shopping cart with 3 Apples, 3 Oranges " should "have a checkout cost of £1.70" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange, new Apple, new Orange)) == 2.55)
  }
}
