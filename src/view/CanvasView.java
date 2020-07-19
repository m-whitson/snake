package view;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

import controller.Features;

public class CanvasView extends JFrame implements SnakeView {

  private final int scale;
  private Features controller;
  private IViewModel model;
  private Field field;


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
    this.add(new JPanel(), BorderLayout.SOUTH);
    this.field.requestFocusInWindow();
    this.addKeyListener(this.field);
    this.setVisible(true);
    this.pack();

    this.validate();

  }

  @Override
  public void repaint() {
    super.repaint();
//    this.field = new Field(this.model, this.scale, this.controller);
//    this.field.repaint();
//    this.setVisible(true);
//    this.pack();
//    this.validate();
  }

  @Override
  public void setFeatures(Features f) {
    this.controller = f;
    this.field.setFeatures(f);
  }

  @Override
  public void setModel(IViewModel m) {
    this.model = m;
  }
}
