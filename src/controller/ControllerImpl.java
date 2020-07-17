package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import model.SnakeModel;
import view.SnakeView;

public class ControllerImpl implements Controller { //}, KeyListener {

  SnakeModel model;
  SnakeView view;
  Listener listener;

  public ControllerImpl(SnakeModel model, SnakeView view) {
    this.model = model;
    this.view = view;
    this.listener = new Listener(this);

  }

  @Override
  public void run(int speed) {
    Timer timer = new Timer(100 / speed, e -> {
      this.listener = new Listener(this);

      this.model.advance();
      this.view.repaint();
    });

    timer.start();

  }

  @Override
  public void turnUp() {
    this.model.advance();
  }

  @Override
  public void turnRight() {
    this.model.turnRight();
  }

  @Override
  public void turnDown() {
    this.model.turnDown();
  }

  @Override
  public void turnLeft() {
    this.model.turnLeft();
  }

  public void listen() {

  }


//  @Override
//  public void keyTyped(KeyEvent e) {
//  }
//
//  @Override
//  public void keyPressed(KeyEvent e) {
//    System.out.println("key");
//    if (e.getKeyCode() == KeyEvent.VK_UP) {
//      this.model.turnUp();
//    }
//    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//      this.model.turnRight();
//    }
//    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//      this.model.turnDown();
//    }
//    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//      this.model.turnLeft();
//    }
//  }
//
//  @Override
//  public void keyReleased(KeyEvent e) {
//  }
}
