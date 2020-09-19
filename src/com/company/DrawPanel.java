package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class DrawPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        drawLandscape(gr);
        for (int i = 0; i < 2; i++) {
            for (int j=0; j<4; j++){
                drawStar(gr, 10 + 150*j + 100*i, 70 + 70*i);
            drawTree(gr, 50 + 240 *j + 50*i, 300 + 100 * i, 150, "round");
            drawTree(gr, 170 + 240 * j + 50*i, 300 + 100 * i, 150, "triangle");
            }
        }

        drawLantern(gr, 250, 500, 350, new Color(170, 170, 170));
        drawBench(gr, 500, 400, 250, 150, new Color(51, 0, 0));
    }

    public static void drawBench(Graphics2D g, int x, int y, int w, int h, Color c ){
        g.setColor(c);
        g.fillRect(x-w/4, y-h/2, w/16, h/2);
        g.fillRect(x+w/4-w/16, y-h/2, w/16, h/2);
        for (int i=0; i<5; i+=2) {
            g.fillRect(x-w/2, y-h/2+i*h/12, w, h/12);
        }
        Path2D.Double parallelogram = new Path2D.Double();
        parallelogram.moveTo(x-w/2,y);
        parallelogram.lineTo(x+w/2,y);
        parallelogram.lineTo(x+w/2+w/8,y+h/6);
        parallelogram.lineTo(x-w/2+w/8,y+h/6 );
        parallelogram.closePath();
        g.fill(parallelogram);
        g.fillRect(x-w/2,y,w/16, h/2);
        g.fillRect(x+w/2-w/16,y,w/16, h/2);
        g.fillRect(x+w/2+w/8-w/16,y+h/6,w/16, h/2);
        g.fillRect(x-w/2+w/8,y+h/6,w/16, h/2);
    }
    public void drawLandscape(Graphics2D g){
        g.setColor(new Color(102, 102, 102));
        g.fillRect(0,3*this.getHeight()/4 , this.getWidth(), this.getHeight()/4);
        g.setColor(new Color(0, 70, 0));
        g.fillRect(0,2*this.getHeight()/4 , this.getWidth(), this.getHeight()/4);
        g.setColor(new Color(0, 0, 100));
        g.fillRect(0,0 , this.getWidth(), this.getHeight()/2);
        g.setColor(new Color(255, 255, 71));
        g.fillArc(3*this.getWidth()/4, this.getHeight()/10, 100, 60, -90, 180 );
        g.setColor(new Color(0, 0, 100));
        g.fillArc(3*this.getWidth()/4+25, this.getHeight()/10, 50, 60, -90, 180 );
        g.setColor(new Color(51, 51, 51));
        BasicStroke sizeLine= new BasicStroke ( 5);
        g.setStroke(sizeLine);
        for(int i=0; i<30; i++){
            g.drawArc(i*50, 3*this.getHeight()/4 - 15, 50, 30, 0, 180 );
        }
        for(int i=0; i<30; i++){
            g.drawArc(i*50, this.getHeight()-15, 50, 30, 0, 180 );
    }
    }
    public static void drawLantern(Graphics2D g, int x, int y,  int h, Color c){
        g.setColor(c);
        g.fillRect(x+h/40,y-h,h/20,4*h/5);
        g.fillRect(x,y-h/5,h/10,h/5);
        BasicStroke sizeLine = new BasicStroke ( 5);
        g.setStroke(sizeLine);
        g.drawArc(x+h/20,y-h-40 , 65, 150, 0,180  );
        g.drawArc(x+h/20-65,y-h-40 , 65, 150, 0,180  );
        g.setColor(Color.YELLOW);
        g.fillOval(x+h/20+65-20, y-h+75-40, 40, 40);
        g.fillOval(x+h/20-65-20, y-h+75-40, 40, 40);
        g.setColor(c);
        g.fillArc(x+h/20+65-25,y-h+75-40 , 50, 40, 0,180  );
        g.fillArc(x+h/20-65-25,y-h+75-40 , 50, 40, 0,180  );


    }

    public static void drawTree(Graphics2D g, int x, int y, int h, String shape) {
        if (shape.equals("round")) {
            g.setColor(new Color(0, 140, 0));
            g.fillOval(x - 2 * h / 5, y - h, 4 * h / 5, 4 * h / 5);

        } else if (shape.equals("triangle")) {
            g.setColor(new Color(0, 40, 0));
            g.fillOval(x - h / 3, y - 3 * h / 8, 2 * h / 3, h / 4);
            Path2D.Double triangle = new Path2D.Double();
            triangle.moveTo(x, y - h);
            triangle.lineTo(x - h / 3, y - h / 4);
            triangle.lineTo(x + h / 3, y - h / 4);
            triangle.closePath();
            g.fill(triangle);
        }
        g.setColor(new Color(70, 51, 0));
        BasicStroke sizeLine = new BasicStroke(7);
        g.setStroke(sizeLine);
        g.drawLine(x, y, x, y - 2 * h / 3);
        g.drawLine(x, y-h/2, x - h/10, y - 5*h / 8);
        g.drawLine(x, y-h/4, x + h/10, y - 3*h / 8);
    }
    public static void drawStar(Graphics2D g, int x, int y) {
        g.setColor(new Color(255, 255, 71));
        BasicStroke sizeLine = new BasicStroke(1);
        g.setStroke(sizeLine);
        double da = 2 * Math.PI / 5;
        for (int i = 0; i < 5; i++) {
            double dx = 8* Math.cos(da * i);
            double dy = 8 * Math.sin(da * i);
            g.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }
}

