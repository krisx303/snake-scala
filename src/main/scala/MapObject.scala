package com.akgroup.snake

abstract class MapObject(protected var position: Position) extends IRenderable {
  def getPosition: Position = position
  def setPosition(position: Position): Unit = {
    this.position = position
  }
}
