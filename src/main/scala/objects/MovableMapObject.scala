package com.akgroup.snake
package objects

abstract class MovableMapObject(private var startPos: Position) extends MapObject(startPos) {
  def getX = position.getX
  def getY = position.getY
}