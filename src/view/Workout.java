package view;

import view.buttons.*;
import io.DataProcessing;
import model.TrainingDay;

import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.util.HashSet;


public class Workout extends JFrame {
    public HashSet<String> days = new HashSet<>();
    public HashSet<TrainingDay> trDays = new HashSet<>();
    public Workout() {
        super("Workout");

        String path = "src/io/data.txt";
        File file = new File(path);
        if (!(file.length() == 0L)) {
            DataProcessing.fromFileToSet(file, trDays);
            for(TrainingDay trd : trDays) days.add(trd.getDayMonth());

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
        res.addActionListener(this, trDays);

        ExitButton exit = new ExitButton("Exit");
        exit.exitActionListener(trDays, file);

        p1.add(day);
        p1.add(add);
        p1.add(res);
        p1.add(exit);
    }
}
