package com.company;

import java.awt.*;

public class Lantern implements Drawable {
    int x;
    int y;
    int height;
    Color c;

    public Lantern(int x, int y, int height, Color c) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.c = c;
    }

    private void drawLantern(Graphics2D g, int x, int y, int height, Color c) {
        g.setColor(c);
        g.fillRect(x + height / 40, y - height, height / 20, 4 * height / 5);
        g.fillRect(x, y - height / 5, height / 10, height / 5);
        BasicStroke sizeLine = new BasicStroke(5);
        g.setStroke(sizeLine);
        g.drawArc(x + height / 20, y - height - 40, 65, 150, 0, 180);
        g.drawArc(x + height / 20 - 65, y - height - 40, 65, 150, 0, 180);
        g.setColor(Color.YELLOW);
        g.fillOval(x + height / 20 + 65 - 20, y - height + 75 - 40, 40, 40);
        g.fillOval(x + height / 20 - 65 - 20, y - height + 75 - 40, 40, 40);
        g.setColor(c);
        g.fillArc(x + height / 20 + 65 - 25, y - height + 75 - 40, 50, 40, 0, 180);
        g.fillArc(x + height / 20 - 65 - 25, y - height + 75 - 40, 50, 40, 0, 180);
    }

    @Override
    public void draw(Graphics2D gr) {
        drawLantern(gr, x, y, height, c);
    }
}
