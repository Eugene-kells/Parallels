import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

class Ball {
    private Component canvas;
    private ArrayList<Hole> holes;
    private Color color;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 1;
    private int dy = 1;


    public Ball(Component c, ArrayList<Hole> holes, Color color) {
        this.canvas = c;
        this.holes = holes;
        this.color = color;

//        if (Math.random() < 0.5) {
//            x = new Random().nextInt(this.canvas.getWidth());
//            y = 0;
//        } else {
//            x = 0;
//            y = new Random().nextInt(this.canvas.getHeight());
//        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public void move() throws InterruptedException {
        x += dx;
        y += dy;
        for (Hole hole : holes) {
            if (hole.checkHit(x, x + XSIZE, y, y + YSIZE))
                throw new InterruptedException("Hit the hole!");
        }
        if (x <= 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y <= 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

    public void updateInfo() {
        System.out.flush();
        StringBuilder resultStr = new StringBuilder();
        for (Hole hole: holes) {
            resultStr.append("\n");
            resultStr.append(hole.getInfo());
        }
        System.out.print(resultStr);
    }
}
