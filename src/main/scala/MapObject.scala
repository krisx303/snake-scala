package com.akgroup.snake

abstract class MapObject(protected var x: Int, protected var y: Int) extends IRenderable {
  def getX: Int = x
  def getY: Int = y
  def getPosition: (Int, Int) = (x, y)
}
