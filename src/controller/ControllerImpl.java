package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import model.SnakeModel;
import view.IViewModel;
import view.SnakeView;

public class ControllerImpl implements Controller, Features { //}, KeyListener {

  SnakeModel model;
  SnakeView view;

  public ControllerImpl(SnakeModel model, SnakeView view) {
    this.model = model;
    this.view = view;

  }

  @Override
  public void run(int speed) {
    Timer timer = new Timer(100 / speed, e -> {

      this.model.advance();
      this.view.repaint();

    });

    timer.start();

  }

  @Override
  public void turnUp() {
    this.model.turnUp();
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

}
