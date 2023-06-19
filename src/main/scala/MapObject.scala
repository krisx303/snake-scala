package com.akgroup.snake

abstract class MapObject(private var x: Int, private var y: Int) {
  def getX(): Int = x
  def getY(): Int = y
  def getPosition(): (Int, Int) = (x, y)
}
