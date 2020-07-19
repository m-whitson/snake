package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

import controller.Controller;
import controller.ControllerImpl;
import controller.Features;
import model.SnakeModel;
import model.SnakeModelImpl;

public class CanvasView extends JFrame implements SnakeView {

  private final int scale;
  private Features controller;
  private IViewModel model;
  private Field field;
  private JPanel panel;
  private JLabel lengthField;


  public CanvasView(IViewModel model, int scale) {
    super();

    this.model = model;
    this.scale = scale;

    int scaledWidth = model.getWidth() * scale;
    int scaledHeight = model.getHeight() * scale;

    this.setSize(scaledWidth, scaledHeight);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    this.field = new Field(model, scale);

    field.setPreferredSize(new Dimension(scaledWidth, scaledHeight));
    this.add(field);

    this.panel = new JPanel();
    this.panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    this.panel.setPreferredSize(new Dimension(scaledWidth, 35));
    this.panel.add(new JLabel("length: "));
    this.lengthField = new JLabel("1");
    this.panel.add(lengthField);

    this.add(this.panel, BorderLayout.SOUTH);
    this.field.requestFocusInWindow();
    this.addKeyListener(this.field);
    this.setVisible(true);
    this.pack();

    this.validate();

  }

  @Override
  public void repaint() {
    super.repaint();
  }

  @Override
  public void setFeatures(Features f) {
    this.controller = f;
    this.field.setFeatures(f);
  }

  @Override
  public void setModel(IViewModel m) {
    this.model = m;
    this.lengthField.setText(String.valueOf(m.getSnake().size()));
    this.pack();
    this.validate();
  }

  @Override
  public void gameOver() {

    JButton tryAgain = new JButton("New Game");
    tryAgain.addActionListener((ActionEvent e) -> {

      SnakeModel tempModel = new SnakeModelImpl(this.model.getWidth(), this.model.getHeight());
      SnakeView tempView = new CanvasView((IViewModel)tempModel, 10);
      Controller tempController = new ControllerImpl(tempModel, tempView);
      tempView.setFeatures((Features)tempController);
      tempController.run(this.controller.getSpeed());


    });

    JLabel empty = new JLabel("        ");

    JLabel gameOver = new JLabel("GAME OVER");


    if (this.panel.getComponentCount() < 3) {
      this.panel.add(empty);
      this.panel.add(gameOver);
      this.panel.add(tryAgain);
      this.pack();
      this.validate();
    }


  }
}
