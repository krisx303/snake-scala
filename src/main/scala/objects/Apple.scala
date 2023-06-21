package com.akgroup.snake
package objects

import objects.snake.{Head, Tail}

class Apple(private val pos: Position) extends MapObject(pos) {
  override def render(): String = {"🍎"}
}

object Apple{
  def apply(startPos: Position): Apple = new Apple(startPos)
  def apply(startPos: (Int, Int)): Apple = new Apple(Position(startPos))
  def apply(x: Int, y: Int): Apple = new Apple(Position(x, y))
}