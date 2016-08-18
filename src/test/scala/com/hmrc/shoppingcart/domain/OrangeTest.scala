package com.hmrc.shoppingcart.domain

import org.scalatest.{FlatSpec, Matchers}
/**
  * This is test class for Item - Orange
  *
  * @author  Naresh Soni
  */
class OrangeTest extends FlatSpec with Matchers {
  val defaultOrange = new Orange
  val customOrange = new Orange(0.90, "NonFruit");

  defaultOrange should not be (null)

  defaultOrange should have (
    'itemType ("Fruit"),
    'price (0.25)
  )

  customOrange should not be (null)

  customOrange should have (
    'itemType ("NonFruit"),
    'price (0.90)
  )
}