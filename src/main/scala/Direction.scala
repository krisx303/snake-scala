package com.akgroup.snake


sealed trait Direction {
  val x: Int
  val y: Int
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