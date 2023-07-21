package view;

import model.TrainingDay;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class ResultsTable extends JTable {

    public ResultsTable(TrainingDay trainingDay){
        super(trainingDay.getData(), new Vector<>(Arrays.asList("Exercise", "Number of sets/reps", "Weight, kg")));
        setPreferredSize(new Dimension(1200, 200));
    }

}
