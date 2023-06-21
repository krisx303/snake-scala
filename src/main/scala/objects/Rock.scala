package com.akgroup.snake
package objects

class Rock(private val posx: Int, private val posy: Int) extends MapObject(posx, posy) {
  override def render(): String = {
    "⬛"
  }
}
