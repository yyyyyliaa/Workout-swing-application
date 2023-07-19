package view.buttons;

import view.TextFieldWindow;
import model.TrainingDay;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class AddButton extends JButton {

    private final String[] workoutType = {"Deadlift", "Squat", "Bench press"};

    private final Object[] deadliftExercises = new String[] {"Deadlift", "Hyperextension", "Pull-ups", "Block thrust", "Biceps"};
    private final Object[] squatExercises = new String[] {"Squat", "Hyperextension", "Quadriceps", "Foot press", "Сalf muscle"};
    private final Object[] benchPressExercises = new String[] {"Bench press", "Pec deck", "Triceps", "Bars", "Shoulder press"};


    public AddButton(String text){
        super(text);
    }

    private boolean checkDataFormat(int d, int m){
        return (m != 4 && m != 6 && m != 9 && m != 11 && m != 2 && d>0 && d<32) ||
                (m == 2 && d < 29 && d>0) ||
                ((m == 4 || m == 6 || m == 9 || m == 11) && d < 31 && d > 0);
    }

    public void addActionListener(HashSet<String> days, HashSet<TrainingDay> trDays, JPanel p2, JFrame f){
        super.addActionListener(e -> {
            String data;
            data = JOptionPane.showInputDialog(p2,"Enter the date in the format: dd/mm");
            int d, m;

            if(data.length()<5) JOptionPane.showMessageDialog(p2,"Wrong data");
            else{
                if(data.charAt(2) == '/'){
                    String[] tokens = data.split("/");
                    d = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                } else {
                    JOptionPane.showMessageDialog(p2,"Wrong data");
                    return;
                }

                if(checkDataFormat(d, m)){

                    String getWorkoutType = (String) JOptionPane.showInputDialog(
                            p2,
                            "Choose the type of workout:",
                            "view.Workout type",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            workoutType,
                            " ");


                    Object[] exercise;

                    if(getWorkoutType.equals("Deadlift")) exercise  = deadliftExercises;
                    else if(getWorkoutType.equals("Squat")) exercise  = squatExercises;
                    else exercise  = benchPressExercises;

                    String[] res = new String[5];

                    TextFieldWindow textFieldWindow = new TextFieldWindow(res, exercise, f);
                    textFieldWindow.setSize(new Dimension(1200,400));
                    textFieldWindow.setLayout(new GridLayout(4, 1));
                    textFieldWindow.setLocation(450,200);

                    textFieldWindow.setVisible(true);

                    int flag = 0;
                    for(String s : res){
                        if (s==null){
                            flag = 1;
                            break;
                        }
                    }

                    if(flag==0){
                        TrainingDay trd = new TrainingDay(data, res, getWorkoutType, exercise);
                        trDays.add(trd);
                        days.add(data);
                    }
                } else JOptionPane.showMessageDialog(p2,"Wrong data");
            }
        });


    }
}
