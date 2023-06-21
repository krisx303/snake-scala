package com.akgroup.snake
package ui

import objects.MapObject

import java.awt.event.KeyListener

trait IUserInterface {

  def updateInterface(objects: Map[(Int, Int), MapObject]): Unit

  def showGameOver(): Unit

  def initInterface(): Unit

  def addKeyListener(keyListener: KeyListener): Unit
}
