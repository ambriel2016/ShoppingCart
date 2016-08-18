package com.hmrc.shoppingcart.service

/**
  * Created by Naresh on 17/08/2016.
  */

import com.hmrc.shoppingcart.businessrules.{ActualPrice, ThreeForTwoOffer, BuyOneGetOneFree, Offer}
import com.hmrc.shoppingcart.domain.{Item, Orange, Apple}
import com.hmrc.shoppingcart.service.{ShoppingCartServiceImpl, ShoppingCartService}
import org.scalatest.{FlatSpec, Matchers}


class ShoppingCartServiceImplTest extends FlatSpec with Matchers {
  private val shoppingCart: ShoppingCartService = new ShoppingCartServiceImpl
  private val noOffer: Map[Item, Offer] = Map(new Apple -> ActualPrice, new Orange -> ActualPrice)

  private val itemsOffer: Map[Item, Offer] = Map(new Apple -> BuyOneGetOneFree, new Orange -> ThreeForTwoOffer)


  "An empty shopping cart " should "have a checkout cost of £0.00" in {
    assert(shoppingCart.checkoutCost(List(),noOffer) == 0.00)
  }

  "A shopping cart with 1 Apple " should "have a checkout cost of £0.60" in {
    assert(shoppingCart.checkoutCost(List(new Apple),noOffer) == 0.60)
  }

  "A shopping cart with 2 Apples " should "have a checkout cost of £0.60" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple),noOffer) == 1.20)
  }

  "A shopping cart with 3 Apples " should "have a checkout cost of £1.20" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Apple),noOffer) == 1.80)
  }

  "A shopping cart with 4 Apples " should "have a checkout cost of £1.20" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Apple, new Apple),noOffer) == 2.40)
  }

  "A shopping cart with 1 Orange " should "have a checkout cost of £0.25" in {
    assert(shoppingCart.checkoutCost(List(new Orange),noOffer) == 0.25)
  }

  "A shopping cart with 2 Oranges " should "have a checkout cost of £0.50" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange),noOffer) == 0.50)
  }

  "A shopping cart with 3 Oranges " should "have a checkout cost of £0.50" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange, new Orange),noOffer) == 0.75)
  }

  "A shopping cart with 4 Oranges " should "have a checkout cost of £0.75" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange, new Orange, new Orange),noOffer) == 1.00)
  }

  "A shopping cart with 1 Apple, 1 Orange " should "have a checkout cost of £0.85" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange),noOffer) == 0.85)
  }

  "A shopping cart with 2 Apples, 1 Orange " should "have a checkout cost of £0.85" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple),noOffer) == 1.45)
  }

  "A shopping cart with 2 Apples, 2 Oranges " should "have a checkout cost of £1.10" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange),noOffer) == 1.70)
  }

  "A shopping cart with 3 Apples, 1 Orange " should "have a checkout cost of £1.45" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Orange, new Apple),noOffer) == 2.05)
  }

  "A shopping cart with 3 Apples, 2 Oranges " should "have a checkout cost of £1.70" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange, new Apple),noOffer) == 2.30)
  }

  "A shopping cart with 3 Apples, 3 Oranges " should "have a checkout cost of £1.70" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange, new Apple, new Orange),noOffer) == 2.55)
  }

  "An empty shopping cart " should "have a checkout cost of £0.00 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(),itemsOffer) == 0.00)
  }

  "A shopping cart with 1 Apple " should "have a checkout cost of £0.60 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple),itemsOffer) == 0.60)
  }

  "A shopping cart with 2 Apples " should "have a checkout cost of £0.60 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple),itemsOffer) == 0.60)
  }

  "A shopping cart with 3 Apples " should "have a checkout cost of £1.20 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Apple),itemsOffer) == 1.20)
  }

  "A shopping cart with 4 Apples " should "have a checkout cost of £1.20 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Apple, new Apple),itemsOffer) == 1.20)
  }

  "A shopping cart with 1 Orange " should "have a checkout cost of £0.25 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Orange),itemsOffer) == 0.25)
  }

  "A shopping cart with 2 Oranges " should "have a checkout cost of £0.50 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange),itemsOffer) == 0.50)
  }

  "A shopping cart with 3 Oranges " should "have a checkout cost of £0.50 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange, new Orange),itemsOffer) == 0.50)
  }

  "A shopping cart with 4 Oranges " should "have a checkout cost of £0.75 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Orange, new Orange, new Orange, new Orange),itemsOffer) == 0.75)
  }

  "A shopping cart with 1 Apple, 1 Orange " should "have a checkout cost of £0.85 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange),itemsOffer) == 0.85)
  }

  "A shopping cart with 2 Apples, 1 Orange " should "have a checkout cost of £0.85 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple),itemsOffer) == 0.85)
  }

  "A shopping cart with 2 Apples, 2 Oranges " should "have a checkout cost of £1.10 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange),itemsOffer) == 1.10)
  }

  "A shopping cart with 3 Apples, 1 Orange " should "have a checkout cost of £1.45 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Apple, new Orange, new Apple),itemsOffer) == 1.45)
  }

  "A shopping cart with 3 Apples, 2 Oranges " should "have a checkout cost of £1.70 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange, new Apple),itemsOffer) == 1.70)
  }

  "A shopping cart with 3 Apples, 3 Oranges " should "have a checkout cost of £1.70 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(new Apple, new Orange, new Apple, new Orange, new Apple, new Orange),itemsOffer) == 1.70)
  }
}
