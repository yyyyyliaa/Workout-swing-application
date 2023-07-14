
import buttons.*;
import data.*;

import javax.swing.*;

import java.awt.*;

import java.io.*;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;

import org.codehaus.jackson.map.ObjectMapper;

public class Workout extends JFrame {
    public HashSet<String> days = new HashSet<>();
    public HashMap<String, TrainingDay> trDays = new HashMap<>();
    public Workout() {
        super("Workout");


        String path = "src/data/dataAboutWorkout.json";
        File file = new File(path);
        if (!(file.length() == 0L)) { //TODO: Реализовать считывание из json-файла в мапу

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
        p1.setLayout(new GridLayout(3, 1));




        DayButton day = new DayButton("Day"); //TODO: Настроить отображение таблицы результатов
        day.addActionListener(days, p2);

        AddButton add = new AddButton("Add"); //TODO: Настроить добавление результатов в таблицу
        add.addActionListener(days, trDays,this);

        ResButton res = new ResButton("Results");
        res.addActionListener(p2);

        p1.add(day);
        p1.add(add);
        p1.add(res);



        ObjectMapper mapper = new ObjectMapper(); //TODO: Реализовать запись данных в файл после завершения программы
        try {
            mapper.writeValue(new File(path), trDays);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
