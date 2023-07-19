package buttons;

import data.DataProcessing;
import data.TrainingDay;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
