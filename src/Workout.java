
import buttons.*;
import data.*;

import javax.swing.*;

import java.awt.*;

import java.io.*;
import java.io.IOException;

import java.util.HashSet;

import org.codehaus.jackson.map.ObjectMapper;


/* TODO: 1)Реализовать ввод результатов и обработка их под объект TrainingDay
         2)Реализовать считывание из файла/запись в таблицу
         3) Разделить String[][] res на String[] res и Integer[] weight */

public class Workout extends JFrame {
    public HashSet<String> days = new HashSet<>();
    public HashSet<TrainingDay> trDays = new HashSet<>();
    public Workout() {
        super("Workout");


        String path = "src/data/dataAboutWorkout.json";
        File file = new File(path);
        if (!(file.length() == 0L)) { //TODO: Реализовать считывание из json-файла в мапу если файл не пустой

        }



        JPanel p1 = new JPanel(new BorderLayout());
        p1.setPreferredSize(new Dimension(200,400));

        JPanel p2 = new JPanel(new BorderLayout());
        p2.setPreferredSize(new Dimension(1200,400));

        setSize(1500, 1000);
        setLocation(100, 100);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        this.add(p1, BorderLayout.WEST);
        this.add(p2,BorderLayout.EAST);
        p1.setLayout(new GridLayout(4, 1));




        DayButton day = new DayButton("Day");
        day.dayActionListener(days, trDays, p2);

        AddButton add = new AddButton("Add");
        add.addActionListener(days, trDays, p2, this);

        ResButton res = new ResButton("Results");
        res.addActionListener(p2);

        ExitButton exit = new ExitButton("Exit");
        exit.exitActionListener(trDays, path);

        p1.add(day);
        p1.add(add);
        p1.add(res);
        p1.add(exit);
    }

    public void jsonToPojo(File f, HashSet<TrainingDay> trDays) throws IOException{ //TODO: ПРОТЕСТИРОВАТЬ!!!
        ObjectMapper objectMapper = new ObjectMapper();
        trDays.add(objectMapper.readValue(f, TrainingDay.class));
    }
}
