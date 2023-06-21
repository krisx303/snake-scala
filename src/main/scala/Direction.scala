package com.akgroup.snake

import Direction.{EAST, NORTH, SOUTH, WEST}


sealed trait Direction {
  val x: Int
  val y: Int

  def getOpposite: Direction = {
    this match {
      case NORTH => SOUTH;
      case EAST => WEST;
      case SOUTH => NORTH;
      case WEST => EAST;
    }
  }
}

object Direction {
  case object NORTH extends Direction {
    val x: Int = 0
    val y: Int = 1
  }

  case object EAST extends Direction {
    val x: Int = 1
    val y: Int = 0
  }

  case object SOUTH extends Direction {
    val x: Int = 0
    val y: Int = -1
  }

  case object WEST extends Direction {
    val x: Int = -1
    val y: Int = 0
  }
}