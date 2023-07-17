
import buttons.*;
import data.*;

import javax.swing.*;

import java.awt.*;

import java.io.*;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.*;
import org.codehaus.jackson.map.ObjectMapper;

public class Workout extends JFrame {
    public HashSet<String> days = new HashSet<>();
    public HashSet<TrainingDay> trDays = new HashSet<>();
    public Workout() {
        super("Workout");


        String path = "src/data/dataAboutWorkout.json";
        File file = new File(path);
        if (!(file.length() == 0L)) { //TODO: Реализовать считывание из json-файла в мапу если файл не пустой


        }


        //Заменяем мапу на сэт
        //Считать json в массив объектов (?)



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




        DayButton day = new DayButton("Day"); //TODO: Настроить отображение таблицы результатов
        day.dayActionListener(days, p2);

        AddButton add = new AddButton("Add"); //TODO: Настроить добавление результатов в таблицу
        add.addActionListener(days, trDays,this);

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
