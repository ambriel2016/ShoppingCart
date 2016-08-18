package com.hmrc.shoppingcart.businessrules

import com.hmrc.shoppingcart.businessrules.{ThreeForTwoOffer, ActualPrice, BuyOneGetOneFree, Offer}
import com.hmrc.shoppingcart.domain.{Orange, Apple}
import org.scalatest.{FlatSpec, Matchers}

/**
  * This is test class for Offer - BuyOneGetOneFree
  *
  * @author  Naresh Soni
  */
class BuyOneGetOneFreeTest extends FlatSpec with Matchers {
  private val offer: Offer =  BuyOneGetOneFree

  "An empty shopping cart " should "have a checkout quantity of 0" in {
    assert(offer.applyOffer(List()) == 0)
  }

  "An shopping cart with 1 apple and BuyOneGetOneFree offer " should "have a checkout quantity of 1" in {
    assert(offer.applyOffer(List(new Apple)) == 1)
  }

  "An shopping cart with 2 apples and BuyOneGetOneFree offer " should "have a checkout quantity of 1" in {
    assert(offer.applyOffer(List(new Apple,new Apple)) == 1)
  }
}
