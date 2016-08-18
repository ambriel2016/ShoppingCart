package com.hmrc.shoppingcart.domain

import org.scalatest.{FlatSpec, Matchers}
/**
  * This is test class for Item - Apple
  *
  * @author  Naresh Soni
  */
class AppleTest extends FlatSpec with Matchers {
  val defaultApple = new Apple
  val customApple = new Apple(0.30, "NonFruit");

  defaultApple should not be (null)

  defaultApple should have (
    'itemType ("Fruit"),
    'price (0.60)
  )

  customApple should not be (null)

  customApple should have (
    'itemType ("NonFruit"),
    'price (0.30)
  )
}
