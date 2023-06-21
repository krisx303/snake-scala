package com.akgroup.snake

import objects.snake.{Head, Tail}
import objects.{MovableMapObject, Rock}

class WorldMap(val height: Int, val width: Int, private var objects: Map[(Int, Int), MapObject] = Map()) {
  def moveTo(head: Head, direction: Direction): Unit = {
    if (!canMoveTo(head, direction)) {
      return;
      //TODO implement game over case
    }
    val lastPosition = head.getPosition;
    objects -= head.getPosition
    head.move(direction)
    objects += head.getPosition -> head
    moveTo(head.nextTail, lastPosition)
  }

  def moveTo(tail: Tail, position: (Int, Int)): Unit = {
    val lastPosition = tail.getPosition;
    objects -= tail.getPosition
    tail.move(position)
    objects += tail.getPosition -> tail
    if (tail.nextTail != null)
      moveTo(tail.nextTail, lastPosition)
  }

  def addObject(obj: MapObject): Boolean = {
    val position = obj.getPosition
    if (objects.contains(position))
      return false;
    this.objects += obj.getPosition -> obj
    return true;
  }

  def printMap(): Unit = {
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n")
    for (y <- height-1 to 0 by -1) {
      for (x <- 0 until width) {
        val obj: Option[MapObject] = objects.get((x, y))
        if (obj.isEmpty) {
          printf("⬜")
        }
        else {
          printf(obj.get.render())
        }
      }
      println("")
    }
  }

  def canMoveTo(obj: MovableMapObject, direction: Direction): Boolean = {
    val x: Int = obj.getX + direction.x
    val y: Int = obj.getY + direction.y
    if (x < 0 || y < 0 || x >= width || y >= height)
      return false
    var mapObject: Option[MapObject] = objects.get((x, y));
    if (mapObject.isEmpty)
      return true
    return !mapObject.get.isInstanceOf[Rock]
  }
}

object WorldMap {
  def apply(height: Int, width: Int): WorldMap = {
    return new WorldMap(height, width);
  }
}