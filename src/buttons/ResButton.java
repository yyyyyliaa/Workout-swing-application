package buttons;

import chart.Chart;

import javax.swing.*;

public class ResButton extends JButton {
    public ResButton(String text){ //TODO: Настроить связь между выбранным днем и построением графика
        super(text);
    }

    public void addActionListener(JPanel p){
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
            int[] y = {100, 80, 120, 100, 80, 120, 100, 80, 120};
            for (int i = 0; i < 3 / 2; i++) {
                int tmp = y[i];
                y[i] = y[y.length - i - 1];
                y[y.length - i - 1] = tmp;
            }
            new Chart(y, Integer.parseInt(data[0]), p, getPeriod).setVisible(true);
        });;
    }
}
