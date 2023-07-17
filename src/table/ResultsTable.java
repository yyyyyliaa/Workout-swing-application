package table;

import javax.swing.*;
import java.util.Vector;

public class ResultsTable extends JTable {
    private String workoutType;
    private Object[] columnsHeader = new String[] {"Exercise", "Number of sets/reps", "Weight, kg"};
    private Object[] deadliftExercises = new String[] {"Hyperextension", "Pull-ups", "Block thrust", "Biceps"};
    private Object[] squatExercises = new String[] {"Hyperextension", "Quadriceps", "Foot press", "Сalf muscle"};

    public ResultsTable(String[][] res){
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        Vector<String> header = new Vector<String>();

        Object[] exercies;

        if(workoutType.equals("deadliftExercises")) exercies  = deadliftExercises;
        else exercies  = squatExercises;

        for (int j = 0; j < columnsHeader.length; j++) {
            header.add((String)columnsHeader[j]);
            Vector<String> row = new Vector<String>();
            row.add((String)exercies[0]);
            for (int i = 1; i < columnsHeader.length + 1; i++) {
                row.add((String)res[j][i]);
            }
            data.add(row);
        }

    }

//    public static void resProcessing(Vector<Vector<String>> data, Vector<String> header ){
//        Object[] exercies;
//
//        if(workoutType.equals("deadliftExercises"))
//
//            for (int j = 0; j < columnsHeader.length; j++) {
//                header.add((String)columnsHeader[j]);
//                Vector<String> row = new Vector<String>();
//                row.add()
//                for (int i = 1; i < 3; i++) {
//                    row.add((String)res[j][i]);
//                }
//                data.add(row);
//            }
//    }


}
