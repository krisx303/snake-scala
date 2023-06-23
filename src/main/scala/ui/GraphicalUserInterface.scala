//package com.akgroup.snake
//package ui
//import objects.MapObject
//
//import scalafx.application.JFXApp3
//import scalafx.application.JFXApp3.PrimaryStage
//import scalafx.scene.Scene
//import scalafx.scene.layout.GridPane
//import scalafx.scene.paint.Color
//import scalafx.scene.shape.Rectangle
//
//import java.awt.event.KeyListener
//
//class GraphicalUserInterface(private val height: Int, private val width: Int) extends IUserInterface {
//  override def updateInterface(objects: Map[(Int, Int), MapObject]): Unit = {
//
//  }
//
//  override def showGameOver(): Unit = {
//
//  }
//
//  override def initInterface(): Unit = {
//    JFXApp3.launch(classOf[SnakeWindow])
//  }
//
//  override def addKeyListener(keyListener: KeyListener): Unit = {
//
//  }
//}
//
//class SnakeWindow extends JFXApp3 {
//  override def start(): Unit = {
//    val gridPane = new GridPane()
//    gridPane.gridLinesVisible = true
//    gridPane.setHgap(2)
//    gridPane.setVgap(2)
//
//    // Add grid cells with colored rectangles
//    val numRows = 14
//    val numCols = 14
//    for (row <- 0 until numRows; col <- 0 until numCols) {
//      val rectangle = createRectangle(Color.White)
//
//      gridPane.add(rectangle, col, row)
//    }
//
//    val scene = new Scene(gridPane, 14*64, 14*64)
//    stage = new PrimaryStage()
//    stage.title = "Grid Window Example"
//    stage.scene = scene
//    stage.show()
//
//    gridPane.add(createRectangle(Color.Blue), 2, 2)
//  }
//
//  def createRectangle(color: Color): Rectangle = {
//    val rectangle = new Rectangle()
//    rectangle.width = 62
//    rectangle.height = 62
//    rectangle.fill = color
//    rectangle
//  }
//}