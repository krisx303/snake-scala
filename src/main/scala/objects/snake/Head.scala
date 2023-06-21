package com.akgroup.snake
package objects.snake

import objects.MovableMapObject

class Head(private val posx: Int, private val posy: Int, var nextTail: Tail) extends MovableMapObject(posx, posy) {

  override def render(): String = {
    return "🟢"
  }

  def move(direction: Direction): Unit = {
    x += direction.x
    y += direction.y
  }
}