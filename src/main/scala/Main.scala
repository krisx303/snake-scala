package com.akgroup.snake

import ui.ConsoleUserInterface


object Main {
  def main(args: Array[String]): Unit = {
    val worldMap: WorldMap = WorldMap(14, 14)
    val interface = new ConsoleUserInterface(14, 14)
    val engine: GameEngine = GameEngine(worldMap, interface)
    engine.initSnake(3, 5)
    interface.initInterface()
    interface.addKeyListener(engine)
    engine.startGame()
  }
}