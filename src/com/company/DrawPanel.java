package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private Bench b = new Bench(500, 400, 250, 150, new Color(51, 0, 0));
    private Landscape ls = new Landscape(600, 800);
    private Lantern lt = new Lantern(250, 500, 350, new Color(170, 170, 170));
    private Forest f = new Forest(50, 300, 150);

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        ls.draw(gr);
        f.draw(gr);
        b.draw(gr);
        lt.draw(gr);
    }

}



