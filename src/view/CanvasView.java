package view;

import java.awt.*;

import javax.swing.*;

public class CanvasView extends JFrame implements SnakeView {

//  private int tick;
  private final int scale;
  private final int ticksPerSecond;


  public CanvasView(IViewModel model, int scale, int ticksPerSecond) {
    super();

    this.scale = scale;
    this.ticksPerSecond = ticksPerSecond;

    int scaledWidth = model.getWidth() * scale;
    int scaledHeight = model.getHeight() * scale;

    this.setSize(scaledWidth, scaledHeight);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    Field field = new Field(model, scale);

    field.setPreferredSize(new Dimension(scaledWidth, scaledHeight));
    this.add(field);

//    this.tick = 0;

//    Timer timer = new Timer(1000 / this.ticksPerSecond, e -> {
//      repaint();
//      tick++;
//    });

    this.setVisible(true);
    this.pack();

//    timer.start();


  }

  @Override
  public void repaint() {
    super.repaint();
    //repaint();
  }

}
