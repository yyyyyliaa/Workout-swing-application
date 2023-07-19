package chart;

import javax.swing.*;
import java.awt.*;

public class Chart extends JFrame {
    public final int[] xFor3days = {160, 360, 560};
    public final int[] xFor7Days = {160, 260, 360, 460, 560, 660, 760};
    public final int[] xFor30Days = {160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540, 560, 580, 600, 620, 640, 660, 680, 700, 720, 740};
    public  int[] y;
    public int n;

    public Chart (int[] y, int n, JPanel p, String text) {
        super(text);
        this.y = y;
        this.n = n;
        setContentPane(p);
        if (n==3) p.add(new DrawingComponent(xFor3days, y, n, p), BorderLayout.CENTER);
        else if (n==7) p.add(new DrawingComponent(xFor7Days, y, n, p), BorderLayout.CENTER);
        else p.add(new DrawingComponent(xFor30Days, y, n, p), BorderLayout.CENTER);
        setSize(800, 1000);
        setLocation(1100,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}