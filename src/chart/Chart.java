package chart;

import javax.swing.*;
import java.awt.*;

public class Chart extends JDialog {
    public final int[] xFor3days = {160, 360, 560};
    public final int[] xFor7Days = {160, 260, 360, 460, 560, 660, 760};
    public final int[] xFor30Days = {160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540, 560, 580, 600, 620, 640, 660, 680, 700, 720, 740};
    public  int[] y;
    public int daysCount;

    public Chart (int[] y, int daysCount, JFrame p, String text, String[] days) {
        super(p, text, true);
        this.y = y;
        this.daysCount = daysCount;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (daysCount==3) add(new DrawingComponent(xFor3days, y, daysCount, days), BorderLayout.CENTER);
        else if (daysCount==7) add(new DrawingComponent(xFor7Days, y, daysCount, days), BorderLayout.CENTER);
        else add(new DrawingComponent(xFor30Days, y, daysCount, days), BorderLayout.CENTER);

        setSize(800, 1000);
        setLocation(1100,100);
        setLocationRelativeTo(null);
    }
}