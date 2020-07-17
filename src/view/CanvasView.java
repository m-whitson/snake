package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class CanvasView extends JFrame implements SnakeView {

  private final int scale;


  public CanvasView(IViewModel model, int scale) {
    super();

    this.scale = scale;

    int scaledWidth = model.getWidth() * scale;
    int scaledHeight = model.getHeight() * scale;

    this.setSize(scaledWidth, scaledHeight);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    Field field = new Field(model, scale);

    field.setPreferredSize(new Dimension(scaledWidth, scaledHeight));
    this.add(field);


    this.setVisible(true);
    this.pack();


  }

  @Override
  public void repaint() {
    super.repaint();
  }

}
