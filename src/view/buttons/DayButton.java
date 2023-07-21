package view.buttons;

import model.TrainingDay;
import model.Trainings;
import view.ResultsTable;

import javax.swing.*;
import java.util.HashSet;

public class DayButton extends JButton {
    public DayButton(String text) {
        super(text);
    }

    public void dayActionListener(Trainings trainings, JPanel p2) {
        super.addActionListener(e -> {

            Object[] optionsToChoose = trainings.getDays().toArray();

            String getDay = (String) JOptionPane.showInputDialog(
                    p2,
                    "Chose the day",
                    "Day",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    " ");


            if(!(getDay ==null)){
                if(!getDay.equals(" ")) {
                    this.setLabel(getDay);
                    p2.removeAll();
                    ResultsTable resultsTable = new ResultsTable(trainings.findDay(getDay));
                    p2.add(resultsTable);
                }
            }
        });
    }
}


