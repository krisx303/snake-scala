package com.akgroup.snake

import com.akgroup.snake.Direction.{EAST, NORTH, SOUTH, WEST}
import com.akgroup.snake.objects.snake.{Head, Tail}

import java.awt.event.{KeyEvent, KeyListener}

class GameEngine(private val worldMap: WorldMap) extends KeyListener {

  var head: Head = _
  var direction: Direction = NORTH;
  def initSnake(x: Int, y: Int): Unit = {
    val tail: Tail = new Tail(x, y-1, null)
    head = new Head(x, y, tail)
    worldMap.addObject(tail)
    worldMap.addObject(head)
  }

  def startGame(): Unit = {
    var running: Boolean = true;
    while (running) {
      worldMap.printMap()
      Thread.sleep(500)
      worldMap.moveTo(head, direction)
    }
  }


  /** Key listener functions */

  override def keyTyped(e: KeyEvent): Unit  = {}

  override def keyPressed(e: KeyEvent): Unit = {
    val keyCode = e.getKeyCode

    direction = keyCode match {
      case 83 => SOUTH;
      case 65 => WEST;
      case 68 => EAST;
      case 87 => NORTH;
    }
  }

  override def keyReleased(e: KeyEvent): Unit = {}
}


object GameEngine {
  def apply(worldMap: WorldMap): GameEngine = {
    return new GameEngine(worldMap)
  }
}