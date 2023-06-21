package com.akgroup.snake
package objects

class Apple(private val posx: Int, private val posy: Int) extends MapObject(posx, posy) {
  override def render(): String = {
    "🍎"
  }
}