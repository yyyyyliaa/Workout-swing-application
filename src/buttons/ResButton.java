package buttons;

import chart.Chart;
import data.TrainingDay;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ResButton extends JButton {
    public ResButton(String text){ //TODO: Настроить связь между выбранным днем и построением графика
        super(text);
    }

    public void addActionListener(JPanel p, HashSet<TrainingDay> trDays){
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

            List<Integer> weights = new ArrayList<>();
            for(TrainingDay t : trDays) weights.add(t.getWeight());
            int[] y = new int[30];
            for(int i = 0; i<30; i++) y[i] = 700;
            int k = 0;
            for(Integer j : weights){
                y[k] = j;
                k++;
            }


            for (int i = 0; i < 3 / 2; i++) {
                int tmp = y[i];
                y[i] = y[y.length - i - 1];
                y[y.length - i - 1] = tmp;
            }
            p.removeAll();
            new Chart(y, Integer.parseInt(data[0]), p, getPeriod).setVisible(true);
        });;
    }
}
