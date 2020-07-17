package main;

import javax.swing.*;

import model.Snake;
import model.SnakeModel;
import model.SnakeModelImpl;
import view.CanvasView;
import view.IViewModel;
import view.SnakeView;

public class Main {


  public static void main(String[] args) {

    int speed = 2;

    IViewModel model = new SnakeModelImpl(70, 40);
    SnakeView view = new CanvasView(model, 10, speed);

    Timer timer = new Timer(100 / speed, e -> {
      model.advance();
      view.repaint();
    });

    timer.start();

  }
}
