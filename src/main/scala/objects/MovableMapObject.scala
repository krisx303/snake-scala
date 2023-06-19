package com.akgroup.snake
package objects

abstract class MovableMapObject(private var x: Int, private var y: Int) extends MapObject(x, y) {
  def move(direction: Direction): Unit = {
    x += direction.x
    y += direction.y
  }
}