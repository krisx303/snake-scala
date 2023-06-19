package com.akgroup.snake

class WorldMap(val height: Int, val width: Int, private var objects: Map[(Int, Int), Tile] = Map()) {
  def addObject(obj: MapObject): Boolean = {
    val position = obj.getPosition()
    if(objects.contains(position))
      return false;
    this.objects += obj.getPosition() -> new Tile(obj.getX(), obj.getY(), obj)
    return true;
  }

  def printMap(): Unit = {
    for (elem <- objects) {
      println(elem)
    }
  }
}

object WorldMap {
  def apply(height: Int, width: Int): WorldMap = {
    return new WorldMap(height, width);
  }
}