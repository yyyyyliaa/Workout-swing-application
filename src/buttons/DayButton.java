package buttons;

import data.TrainingDay;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;

public class DayButton extends JButton { //TODO: При выборе дня открывается пустая таблица, внизу кнопка "добавить рез-ты"
//    Object[] columnsHeader = new String[] {"Exercise", "Number of sets/reps", "Weight, kg"};
//    Object[][] array = new String[][] {{"Exercise", "Number of sets/reps", "Weight, kg"}, {"ex1", "3/10", "60"}, {"ex2", "3/5", "65"}, {"ex3", "4/10", "70"}};
    public DayButton(String text) {
        super(text);
    }

    public void dayActionListener(HashSet<String> days, JPanel p2) {
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
                    TrainingDay trDay = new TrainingDay(getDay);
                    /*TODO: Здесь создается таблица, конструктор которой принимает объект TrainingDay.
                       Так же нужно реализовать возможность добавления данных в таблицу (сделать кнопку "добавить результаты")
                       В каком классе реализовать кнопки?????
                       Если в ResultsTable, добавить в конструктор параметр JPanel*/


                    //ПРО ДОБАВЛЕНИЕ РЕЗУЛЬТАТОВ: 1) Считать данные в Object[][] res, передать его в конструктор TrainingDay
                    // 2) Сделать добавление результатов при добавлении дня???

//                    JTable table = new JTable(array, columnsHeader);
//                    p2.add(table);
                } else {
                    this.setLabel("Day");
                }
            }
        });
    }
}


