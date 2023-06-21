package com.akgroup.snake

class Position(private val x: Int, private val y: Int) {
  def +(other: Direction): Position = {
    new Position(this.x + other.x, this.y + other.y)
  }

  def +(other: Position): Position = {
    new Position(this.x + other.x, this.y + other.y)
  }

  def intoTuple: (Int, Int) = (x, y)

  def getX: Int = x
  def getY: Int = y
}

object Position{
  def apply(x: Int, y: Int): Position = new Position(x, y)
  def apply(tuple: (Int, Int)): Position = new Position(tuple._1, tuple._2)
}