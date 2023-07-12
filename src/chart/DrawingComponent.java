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
    protected void paintComponent(Graphics gh) { //TODO: График должен выводиться в p2, а не в отдельный экран
        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 700, 20, 20);
        drp.drawLine(20, 700, 750, 700);
        drp.drawPolyline(xg, yg, ng);
    }
}

