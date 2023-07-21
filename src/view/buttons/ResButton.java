package view.buttons;

import model.Trainings;
import view.chart.Chart;
import model.TrainingDay;

import javax.swing.*;
import java.util.*;

public class ResButton extends JButton {
    public ResButton(String text){ super(text);}

    public void addActionListener(Trainings trainings){
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

            trainings.processDataForChart(y, days);

            new Chart(y, period, null, getPeriod, days).setVisible(true);
        });;
    }
}
