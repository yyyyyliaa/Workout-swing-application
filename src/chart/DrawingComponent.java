package chart;

import javax.swing.*;
import java.awt.*;

class DrawingComponent extends JPanel {
    int[] xg;
    int[] yg;
    int ng;

    String[] days;

    public DrawingComponent(int[] x, int[]y, int n, String[] days){
        xg = x;
        yg = y;
        ng = n;
        this.days = days;
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

        for(int i = 0; i<ng; i++){
            drp.drawChars(days[i].toCharArray(), 0, days[i].length(), xg[i], 720);
            int newXcoord = 700- yg[i];
            char[] coord = Integer.toString(newXcoord).toCharArray();
            drp.drawChars(coord, 0, coord.length, 10, yg[i]);
        }

        drp.drawPolyline(xg, yg, ng);
    }
}

