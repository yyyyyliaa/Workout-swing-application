package buttons;

import data.TrainingDay;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;

public class AddButton extends JButton {

    public AddButton(String text){
        super(text);
    }

    private boolean checkDataFormat(int d, int m){
        return (m != 4 && m != 6 && m != 9 && m != 11 && m != 2 && d>0 && d<31) ||
                (m == 2 && d < 29 && d>0) ||
                ((m == 4 || m == 6 || m == 9 || m == 11) && d < 32 && d > 0);
    }

    public void addActionListener(HashSet<String> days, HashSet<TrainingDay> trDays, JFrame w){
        super.addActionListener(e -> {
            String data;
            data = JOptionPane.showInputDialog ("Enter the date in the format: dd/mm");
            int d, m;

            if(data.charAt(2) == '/'){
                String[] tokens = data.split("/");
                d = Integer.parseInt(tokens[0]);
                m = Integer.parseInt(tokens[1]);
            } else {
                JOptionPane.showMessageDialog(w,"Wrong data");
                return;
            }

            if(checkDataFormat(d, m)){
                days.add(data);
                trDays.add(new TrainingDay(d, m));
                /*TODO: Открывается окно с выбором типа тренировки, затем окно для добавления результатов
                *  ПРОВЕРКА НА КОРРЕКТНОСТЬ ВВОДА ДАННЫХ!!!!!*/

            } else {
                JOptionPane.showMessageDialog(w,"Wrong data");
            }
        });


    }
}
