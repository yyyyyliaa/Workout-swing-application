package view.buttons;

import io.DataProcessing;
import model.TrainingDay;

import javax.swing.*;
import java.io.File;
import java.util.HashSet;

public class ExitButton extends JButton {

    public ExitButton(String text){
        super(text);
    }

    public void exitActionListener(HashSet<TrainingDay> trDays, File f){
        super.addActionListener(e -> {
            DataProcessing.fromSetToFile(f, trDays);
            System.exit(0);
        });


    }

}
