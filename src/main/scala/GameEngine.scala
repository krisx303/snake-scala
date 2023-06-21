package com.akgroup.snake

import com.akgroup.snake.Direction.{EAST, NORTH, SOUTH, WEST}
import com.akgroup.snake.objects.{Apple, MapObject}
import com.akgroup.snake.objects.snake.{Head, Tail}
import com.akgroup.snake.ui.IUserInterface

import java.awt.event.{KeyEvent, KeyListener}
import java.time.LocalTime

class GameEngine(private val worldMap: WorldMap, private val userInterface: IUserInterface) extends KeyListener {

  var head: Head = _
  var direction: Direction = NORTH;
  var lastDirection: Direction = direction;

  def initSnake(x: Int, y: Int): Unit = {
    val tail: Tail = Tail(x, y - 1, null)
    head = Head(x, y, tail)
    worldMap.addObject(tail)
    worldMap.addObject(Apple(2, 2))
    worldMap.addObject(head)
  }

  def startGame(): Unit = {
    var running: Boolean = true;
    var increase: Boolean = false;
    while (running) {
      increase = false;
      userInterface.updateInterface(worldMap.getMapObjects)
      Thread.sleep(500)
      if (direction != lastDirection.getOpposite)
        lastDirection = direction
      else
        direction = lastDirection

      if (!worldMap.canMoveTo(head, direction)) {
        userInterface.showGameOver()
        running = false;
        return;
      }
      val obj: Option[MapObject] = worldMap.getObjectAtPosition((head.getPosition + direction).intoTuple)
      if (obj.isDefined && obj.get.isInstanceOf[Apple]) {
        println("Jabłko")
        increase = true;
      }

      if (increase) {
        worldMap.createNewApple(generateNewPosition _)
      }
      worldMap.moveTo(head, direction, increase)
    }
  }

  def generateNewPosition(): Position = {
    Position(LocalTime.now().getNano % 14, LocalTime.now().getNano % 14)
  }


  /** Key listener functions */

  override def keyTyped(e: KeyEvent): Unit = {}

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
  def apply(worldMap: WorldMap, userInterface: IUserInterface): GameEngine = {
    return new GameEngine(worldMap, userInterface)
  }
}