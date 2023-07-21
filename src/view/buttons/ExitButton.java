package view.buttons;

import io.DataProcessing;
import model.Trainings;

import javax.swing.*;
import java.io.File;

public class ExitButton extends JButton {

    public ExitButton(String text){
        super(text);
    }

    public void exitActionListener(Trainings trainings, File f){
        super.addActionListener(e -> {
            DataProcessing.fromSetToFile(f, trainings.getTrDays());
            System.exit(0);
        });


    }

}
