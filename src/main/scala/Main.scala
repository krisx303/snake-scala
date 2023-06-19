package com.akgroup.snake

import objects.Apple

object Main {
  def main(args: Array[String]): Unit = {
    var worldMap: WorldMap = WorldMap(5, 5);
    worldMap.addObject(new Apple(2, 2))
    worldMap.printMap()
    println("Hello world! 🐍");
  }
}
