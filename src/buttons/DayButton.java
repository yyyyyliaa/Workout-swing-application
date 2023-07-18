package buttons;

import data.TextFieldWindow;
import data.TrainingDay;
import table.ResultsTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class DayButton extends JButton { //TODO: При выборе дня открывается пустая таблица, внизу кнопка "добавить рез-ты"
    private String[] workoutType = {"Deadlift", "Squat", "Bench press"};
//    private Object[] deadliftExercises = new String[] {"Hyperextension", "Pull-ups", "Block thrust", "Biceps"};
//    private Object[] squatExercises = new String[] {"Hyperextension", "Quadriceps", "Foot press", "Сalf muscle"};
//    private Object[] benchPressExercises = new String[] {};

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


