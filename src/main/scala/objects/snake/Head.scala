package com.akgroup.snake
package objects.snake

import objects.MovableMapObject

class Head(private val startPos: Position, var nextTail: Tail) extends MovableMapObject(startPos) {

  override def render(): String = {
    return "🟢"
  }

  def move(direction: Direction): Unit = {
    position += direction
  }
}

object Head{
  def apply(startPos: Position, nextTail: Tail): Head = new Head(startPos, nextTail)
  def apply(startPos: (Int, Int), nextTail: Tail): Head = new Head(Position(startPos), nextTail)
  def apply(x: Int, y: Int, nextTail: Tail): Head = new Head(Position(x, y), nextTail)
}