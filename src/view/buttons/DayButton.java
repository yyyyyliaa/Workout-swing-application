package view.buttons;

import model.TrainingDay;
import view.ResultsTable;

import javax.swing.*;
import java.util.HashSet;

public class DayButton extends JButton {
    public DayButton(String text) {
        super(text);
    }

    public void dayActionListener(HashSet<String> days, HashSet<TrainingDay> trDays, JPanel p2) {
        super.addActionListener(e -> {

            Object[] optionsToChoose = days.toArray();

            String getDay = (String) JOptionPane.showInputDialog(
                    p2,
                    "Chose the day",
                    "Day",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    " ");

            if(!(getDay ==null)){
                if(!getDay.equals(" ")){
                    this.setLabel(getDay);

                    for(TrainingDay trd : trDays){
                        if (trd.getDayMonth().equals(getDay)){
                            p2.removeAll();
                            ResultsTable resultsTable = new ResultsTable(trd);
                            p2.add(resultsTable);
                            break;
                        }
                    }

                } else {
                    this.setLabel("Day");
                }
            }
        });
    }
}


