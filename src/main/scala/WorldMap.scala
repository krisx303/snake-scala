package com.akgroup.snake

import objects.snake.{Head, Tail}
import objects.{Apple, MapObject, MovableMapObject, Rock}

class WorldMap(val height: Int, val width: Int, private var objects: Map[(Int, Int), MapObject] = Map()) {
  def addObject(obj: MapObject): Boolean = {
    val position = obj.getPosition
    if (objects.contains(position.intoTuple))
      return false;
    this.objects += obj.getPosition.intoTuple -> obj
    return true;
  }

  def createNewApple(generator: () => Position): Unit = {
    while(true){
      val position = generator();
      if(!objects.contains(position.intoTuple)) {
        this.addObject(Apple(position))
        return
      }
    }
  }

  def moveTo(head: Head, direction: Direction, increase: Boolean): Unit = {
    val lastPosition = head.getPosition;
    objects -= head.getPosition.intoTuple
    head.move(direction)
    objects += head.getPosition.intoTuple -> head
    moveTo(head.nextTail, lastPosition.intoTuple, increase)
  }

  def moveTo(tail: Tail, position: (Int, Int), increase: Boolean): Unit = {
    val lastPosition = tail.getPosition;
    objects -= tail.getPosition.intoTuple
    tail.move(Position(position))
    objects += tail.getPosition.intoTuple -> tail
    if (tail.nextTail != null)
      moveTo(tail.nextTail, lastPosition.intoTuple, increase)
    else if(increase) {
      val newTail = Tail(lastPosition, null)
      objects += newTail.getPosition.intoTuple -> newTail
      tail.nextTail = newTail
    }
  }

  def getObjectAtPosition(position: (Int, Int)): Option[MapObject] = {
    objects.get(position)
  }

  def canMoveTo(obj: MovableMapObject, direction: Direction): Boolean = {
    val x: Int = obj.getX + direction.x
    val y: Int = obj.getY + direction.y
    if (x < 0 || y < 0 || x >= width || y >= height)
      return false
    var mapObject: Option[MapObject] = objects.get((x, y));
    if (mapObject.isEmpty)
      return true
    return !mapObject.get.isInstanceOf[Rock] && !mapObject.get.isInstanceOf[Tail]
  }

  def getMapObjects: Map[(Int, Int), MapObject] = objects;
}

object WorldMap {
  def apply(height: Int, width: Int): WorldMap = {
    return new WorldMap(height, width);
  }
}