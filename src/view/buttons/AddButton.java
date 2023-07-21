package view.buttons;

import model.Trainings;
import javax.swing.*;


public class AddButton extends JButton {

    public AddButton(String text){
        super(text);
    }


    public void addActionListener(Trainings trainings){
        super.addActionListener(e -> {
            String data;
            data = JOptionPane.showInputDialog(null,"Enter the date in the format: dd/mm");
            if(!trainings.addTrainingDay(data)) JOptionPane.showMessageDialog(null,"Wrong data");;
        });
    }
}
