package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.Controller;

public class Listener implements KeyListener {

  private Controller controller;

  public Listener(Controller c) {
    this.controller = c;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("key");
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      this.controller.turnUp();
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      this.controller.turnRight();
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      this.controller.turnDown();
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      this.controller.turnLeft();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
