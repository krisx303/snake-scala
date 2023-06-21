package com.akgroup.snake

import javax.swing.{JFrame, JPanel}


object Main {
  def main(args: Array[String]): Unit = {
    val worldMap: WorldMap = WorldMap(14, 14)
    val engine: GameEngine = GameEngine(worldMap)
    engine.initSnake(3, 5)
    val panel = new JPanel()

    panel.addKeyListener(engine)
    panel.setFocusable(true)

    val frame = new JFrame("Snake GUI placeholder")
    frame.setSize(0, 0)
    frame.add(panel)
    frame.setVisible(true)
    engine.startGame()
  }
}