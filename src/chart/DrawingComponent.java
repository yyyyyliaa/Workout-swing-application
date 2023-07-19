package chart;

import javax.swing.*;
import java.awt.*;

class DrawingComponent extends JPanel {
    int xg[];
    int yg[];
    int ng;
    JPanel p;

    public DrawingComponent(int[] x, int[]y, int n, JPanel p){
        xg = x;
        yg = y;
        ng = n;
        this.p = p;
    }
    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        char[] xt = {'w', 'e', 'i', 'g', 'h', 't'};
        char[] yt = {'d', 'a', 'y'};
        drp.drawLine(100, 700, 100, 50);
        drp.drawLine(100, 50, 97, 57);
        drp.drawLine(100, 50, 103, 57);
        drp.drawLine(100, 700, 750, 700);
        drp.drawLine(750, 700, 743, 697);
        drp.drawLine(750, 700, 743, 703);
        drp.drawChars(xt, 0, 6, 50, 70);
        drp.drawChars(yt, 0, 3, 725, 720);
        drp.drawPolyline(xg, yg, ng);
    }
}

