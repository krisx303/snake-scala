package com.akgroup.snake
package ui

import objects.MapObject

import java.awt.event.KeyListener
import javax.swing.{JFrame, JPanel}

class ConsoleUserInterface(private val height: Int, private val width: Int) extends IUserInterface {

  val panel = new JPanel()
  val frame = new JFrame("Snake GUI placeholder")
  override def updateInterface(objects: Map[(Int, Int), MapObject]): Unit = {
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n")
    for (y <- height - 1 to 0 by -1) {
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

  override def showGameOver(): Unit = {
    println("No i się skończyło")
  }

  override def initInterface(): Unit = {
    panel.setFocusable(true)

    frame.setSize(0, 0)
    frame.add(panel)
    frame.setVisible(true)
  }

  override def addKeyListener(keyListener: KeyListener): Unit = {
    panel.addKeyListener(keyListener)
  }
}
