package com.company;

import java.awt.*;
import java.awt.geom.Path2D;

public class Bench implements Drawable {
    int x;
    int y;
    int w;
    int h;
    Color c;

    public Bench(int x, int y, int w, int h, Color c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
    }

    private static void drawBench(Graphics2D gr, int x, int y, int w, int h, Color c) {
        gr.setColor(c);
        gr.fillRect(x - w / 4, y - h / 2, w / 16, h / 2);
        gr.fillRect(x + w / 4 - w / 16, y - h / 2, w / 16, h / 2);
        for (int i = 0; i < 5; i += 2) {
            gr.fillRect(x - w / 2, y - h / 2 + i * h / 12, w, h / 12);
        }
        Path2D.Double parallelogram = new Path2D.Double();
        parallelogram.moveTo(x - w / 2, y);
        parallelogram.lineTo(x + w / 2, y);
        parallelogram.lineTo(x + w / 2 + w / 8, y + h / 6);
        parallelogram.lineTo(x - w / 2 + w / 8, y + h / 6);
        parallelogram.closePath();
        gr.fill(parallelogram);
        gr.fillRect(x - w / 2, y, w / 16, h / 2);
        gr.fillRect(x + w / 2 - w / 16, y, w / 16, h / 2);
        gr.fillRect(x + w / 2 + w / 8 - w / 16, y + h / 6, w / 16, h / 2);
        gr.fillRect(x - w / 2 + w / 8, y + h / 6, w / 16, h / 2);
    }

    @Override
    public void draw(Graphics2D gr) {
        drawBench(gr, x, y, w, h, c);
    }
}
