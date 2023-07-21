package view;

import view.buttons.AddButton;
import view.buttons.DayButton;
import view.buttons.ExitButton;
import view.buttons.ResButton;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(String title){
        super(title);
        setSize(1500, 1000);
        setLocation(100, 100);
        setDefaultCloseOperation( EXIT_ON_CLOSE );


        JPanel p1 = new JPanel(new BorderLayout());
        p1.setPreferredSize(new Dimension(200,400));
        p1.setLayout(new GridLayout(4, 1));

        Workout workout = new Workout();
        WorkoutView workoutView = new WorkoutView(workout);

        DayButton day = new DayButton("Day");
        day.dayActionListener(workout.getTrainings(), workoutView);

        AddButton add = new AddButton("Add");
        add.addActionListener(workout.getTrainings());

        ResButton res = new ResButton("Results");
        res.addActionListener(workout.getTrainings());

        ExitButton exit = new ExitButton("Exit");
        exit.exitActionListener(workout.getTrainings(), workout.getFile());

        p1.add(day);
        p1.add(add);
        p1.add(res);
        p1.add(exit);

        add(p1, BorderLayout.WEST);
        add(workoutView,BorderLayout.EAST);
    }

    public static void main(String[] args) {

        new MainWindow("Workout").setVisible(true);

    }
}
