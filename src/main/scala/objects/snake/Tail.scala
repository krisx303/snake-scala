package com.akgroup.snake
package objects.snake

import objects.MovableMapObject

class Tail(private val posx: Int, private val posy: Int, var nextTail: Tail) extends MovableMapObject(posx, posy) {
  override def render(): String = {"🟩"}

  def move(position: (Int, Int)): Unit = {
    x = position._1
    y = position._2
  }
}