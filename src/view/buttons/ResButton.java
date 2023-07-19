package view.buttons;

import view.chart.Chart;
import model.TrainingDay;

import javax.swing.*;
import java.util.HashSet;

public class ResButton extends JButton {
    public ResButton(String text){ super(text);}

    public void addActionListener(JFrame p, HashSet<TrainingDay> trDays){
        super.addActionListener(e -> {
            Object[] optionsToChoose = {"3 days", "7 days", "30 days"};
            String getPeriod = (String) JOptionPane.showInputDialog(
                    null,
                    "Chose time period",
                    "Time period",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    " ");
            String[] data = getPeriod.split(" ");
            int period = Integer.parseInt(data[0]);

            int[] y = new int[30];
            String[] days = new String[30];

            for(int i = 0; i<30; i++) {
                y[i] = 700;
                days[i] = "";
            }

            int k = trDays.size()-1;
            for(TrainingDay t : trDays){
                y[k] = 700 - t.getWeight();
                days[k] = t.getDayMonth();
                k--;
            }

            new Chart(y, period, p, getPeriod, days).setVisible(true);
        });;
    }
}
