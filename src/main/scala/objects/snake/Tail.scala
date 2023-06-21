package com.akgroup.snake
package objects.snake

import objects.MovableMapObject

class Tail(private val startPos: Position, var nextTail: Tail) extends MovableMapObject(startPos) {
  override def render(): String = {"🟩"}

  def move(newPosition: Position): Unit = {
    position = newPosition
  }
}

object Tail{
  def apply(startPos: Position, nextTail: Tail): Tail = new Tail(startPos, nextTail)
  def apply(startPos: (Int, Int), nextTail: Tail): Tail = new Tail(Position(startPos), nextTail)
  def apply(x: Int, y: Int, nextTail: Tail): Tail = new Tail(Position(x, y), nextTail)
}