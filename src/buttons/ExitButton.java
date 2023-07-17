package buttons;

import data.TrainingDay;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class ExitButton extends JButton {  //TODO: Реализовать завершение программы и копирование данных в json-файл

    public ExitButton(String text){
        super(text);
    }

    public void exitActionListener(HashSet<TrainingDay> trDays, String path){
        super.addActionListener(e -> {
            ObjectMapper mapper = new ObjectMapper(); //TODO: Реализовать запись данных в файл после завершения программы
            try {
                mapper.writeValue(new File(path), trDays);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        });


    }

}
