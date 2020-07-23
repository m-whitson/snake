package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import model.SnakeModel;
import view.IViewModel;
import view.SnakeView;

public class ControllerImpl implements Controller, Features {

  SnakeModel model;
  SnakeView view;
  int speed;

  public ControllerImpl(SnakeModel model, SnakeView view) {
    this.model = model;
    this.view = view;

  }

  @Override
  public void run(int speed) {

    this.speed = speed;

    Timer timer = new Timer(100 / speed, x -> {
      if (!this.model.isGameOver()) {
        model.advance();
        view.setModel((IViewModel)model);
        view.repaint();
      } else {
        view.gameOver();
      }


    });

    timer.start();

  }

  @Override
  public int getSpeed() {
    return this.speed;
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
