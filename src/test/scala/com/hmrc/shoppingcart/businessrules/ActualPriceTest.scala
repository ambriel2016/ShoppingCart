package com.hmrc.shoppingcart.businessrules

import com.hmrc.shoppingcart.businessrules.{ThreeForTwoOffer, ActualPrice, BuyOneGetOneFree, Offer}
import com.hmrc.shoppingcart.domain.{Orange, Apple}
import org.scalatest.{FlatSpec, Matchers}

/**
  * This is test class for Offer - ActualPrice
  *
  * @author  Naresh Soni
  */
class ActualPriceTest extends FlatSpec with Matchers {
  private val offer: Offer =  ActualPrice

  "An empty shopping cart " should "have a checkout quantity of 0" in {
    assert(offer.applyOffer(List()) == 0)
  }

  "An shopping cart with 1 apples and no offer " should "have a checkout quantity of 1" in {
    assert(offer.applyOffer(List(new Apple)) == 1)
  }

  "An shopping cart with 2 apples and no offer " should "have a checkout quantity of 2" in {
    assert(offer.applyOffer(List(new Apple,new Apple)) == 2)
  }

  "An shopping cart with 1 orange and no offer " should "have a checkout quantity of 1" in {
    assert(offer.applyOffer(List(new Orange)) == 1)
  }

  "An shopping cart with 2 orange and no offer " should "have a checkout quantity of 2" in {
    assert(offer.applyOffer(List(new Orange,new Orange)) == 2)
  }

  "An shopping cart with 3 orange and no offer " should "have a checkout quantity of 3" in {
    assert(offer.applyOffer(List(new Orange,new Orange, new Orange)) == 3)
  }
}
