package com.hmrc.shoppingcart.businessrules

import com.hmrc.shoppingcart.businessrules.{ThreeForTwoOffer, ActualPrice, BuyOneGetOneFree, Offer}
import com.hmrc.shoppingcart.domain.{Orange, Apple}
import org.scalatest.{FlatSpec, Matchers}
/**
  * This is test class for Offer - ThreeForTwoOffer
  *
  * @author  Naresh Soni
  */
class ThreeForTwoOfferTest  extends FlatSpec with Matchers {
  private val offer: Offer =  ThreeForTwoOffer

  "An empty shopping cart " should "have a checkout quantity of 0" in {
    assert(offer.applyOffer(List()) == 0)
  }

  "An shopping cart with 1 orange and ThreeForTwoOffer offer " should "have a checkout quantity of 1" in {
    assert(offer.applyOffer(List(new Orange)) == 1)
  }

  "An shopping cart with 2 orange and ThreeForTwoOffer offer " should "have a checkout quantity of 2" in {
    assert(offer.applyOffer(List(new Orange,new Orange)) == 2)
  }

  "An shopping cart with 3 orange and ThreeForTwoOffer offer " should "have a checkout quantity of 2" in {
    assert(offer.applyOffer(List(new Orange,new Orange, new Orange)) == 2)
  }
}