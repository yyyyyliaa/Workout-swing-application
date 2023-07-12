package buttons;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;

public class DayButton extends JButton {
    Object[] columnsHeader = new String[] {"Exercise", "Number of sets/reps", "Weight, kg"};
    Object[][] array = new String[][] {{"Exercise", "Number of sets/reps", "Weight, kg"}, {"ex1", "3/10", "60"}, {"ex2", "3/5", "65"}, {"ex3", "4/10", "70"}};
    public DayButton(String text) {
        super(text);
    }

    public void addActionListener(HashSet<String> days, JPanel p2) {
        super.addActionListener(e -> {
            Object[] optionsToChoose = days.toArray();
            String getDay = (String) JOptionPane.showInputDialog(
                    null,
                    "Chose the day",
                    "Day",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    " ");
            if(!(getDay ==null)){
                if(!getDay.equals(" ")){
                    this.setLabel(getDay);
                    JTable table = new JTable(array, columnsHeader);
                    p2.add(table);
                } else {
                    this.setLabel("Day");
                }
            }
        });
    }
}


