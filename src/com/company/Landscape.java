package com.company;

import java.awt.*;

public class Landscape implements Drawable {
    int height;
    int width;

    public Landscape(int height, int width) {
        this.height = height;
        this.width = width;
    }

    private void drawScenery(Graphics2D g, int height, int width) {
        g.setColor(new Color(102, 102, 102));
        g.fillRect(0, 3 * height / 4, width, height / 4);
        g.setColor(new Color(0, 70, 0));
        g.fillRect(0, 2 * height / 4, width, height / 4);
        g.setColor(new Color(0, 0, 100));
        g.fillRect(0, 0, width, height / 2);
    }

    private void drawMoon(Graphics2D g, int height, int width) {
        g.setColor(new Color(255, 255, 71));
        g.fillArc(3 * width / 4, height / 10, 100, 60, -90, 180);
        g.setColor(new Color(0, 0, 100));
        g.fillArc(3 * width / 4 + 25, height / 10, 50, 60, -90, 180);

    }

    private void drawFence(Graphics2D g, int height, int width) {
        g.setColor(new Color(51, 51, 51));
        BasicStroke sizeLine = new BasicStroke(5);
        g.setStroke(sizeLine);
        for (int i = 0; i < 30; i++) {
            g.drawArc(i * 50, 3 * height / 4 - 15, 50, 30, 0, 180);
        }
        for (int i = 0; i < 30; i++) {
            g.drawArc(i * 50, height - 15, 50, 30, 0, 180);
        }
    }

    private void drawStar(Graphics2D g, int x, int y) {
        g.setColor(new Color(255, 255, 71));
        BasicStroke sizeLine = new BasicStroke(1);
        g.setStroke(sizeLine);
        double da = 2 * Math.PI / 5;
        for (int i = 0; i < 5; i++) {
            double dx = 8 * Math.cos(da * i);
            double dy = 8 * Math.sin(da * i);
            g.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }

    private void drawSky(Graphics2D g, int height, int width) {
        drawMoon(g, height, width);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                drawStar(g, 3 * width / 40 + 150 * j + 100 * i, height / 10 + 70 * i);
            }
        }
    }

    @Override
    public void draw(Graphics2D gr) {
        drawScenery(gr, height, width);
        drawSky(gr, height, width);
        drawFence(gr, height, width);

    }
}
