package com.company;

import java.awt.*;
import java.awt.geom.Path2D;

public class Forest implements Drawable {
    int x;
    int y;
    int height;

    public Forest(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    private void drawTree(Graphics2D g, int x, int y, int height, String shape) {
        if (shape.equals("round")) {
            g.setColor(new Color(0, 140, 0));
            g.fillOval(x - 2 * height / 5, y - height, 4 * height / 5, 4 * height / 5);

        } else if (shape.equals("triangle")) {
            g.setColor(new Color(0, 40, 0));
            g.fillOval(x - height / 3, y - 3 * height / 8, 2 * height / 3, height / 4);
            Path2D.Double triangle = new Path2D.Double();
            triangle.moveTo(x, y - height);
            triangle.lineTo(x - height / 3, y - height / 4);
            triangle.lineTo(x + height / 3, y - height / 4);
            triangle.closePath();
            g.fill(triangle);
        }
        g.setColor(new Color(70, 51, 0));
        BasicStroke sizeLine = new BasicStroke(7);
        g.setStroke(sizeLine);
        g.drawLine(x, y, x, y - 2 * height / 3);
        g.drawLine(x, y - height / 2, x - height / 10, y - 5 * height / 8);
        g.drawLine(x, y - height / 4, x + height / 10, y - 3 * height / 8);
    }

    private void drawForest(Graphics2D gr, int x, int y) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                drawTree(gr, x + 240 * j + 50 * i, y + 100 * i, 150, "round");
                drawTree(gr, 120 + x + 240 * j + 50 * i, y + 100 * i, 150, "triangle");
            }
        }
    }

    @Override
    public void draw(Graphics2D gr) {
        drawForest(gr, x, y);
    }
}
