package data;

import java.io.*;
import java.util.HashSet;

public class DataProcessing {
    private static final Object[] deadliftExercises = new String[] {"Deadlift", "Hyperextension", "Pull-ups", "Block thrust", "Biceps"};
    private static final Object[] squatExercises = new String[] {"Squat", "Hyperextension", "Quadriceps", "Foot press", "Сalf muscle"};
    private static final Object[] benchPressExercises = new String[] {"Bench press", "Pec deck", "Triceps", "Bars", "Shoulder press"};
    public static void fromFileToSet(File f, HashSet<TrainingDay> trDays){
        String line  = "";
        try(FileReader fr = new FileReader(f)){
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        String[] trDaysData = line.split("&");
        for(String trDayRow : trDaysData){
            String[] trDayRowData = trDayRow.split("%");
            String dayMonth = trDayRowData[0];
            String workoutType = trDayRowData[1];
            String dayResults = trDayRowData[2].substring(1,trDayRowData[2].length()-1 );

            String[] dayResultsMass = dayResults.split(", ");
            Object[] exercise = new Object[5];
            if(workoutType.equals("Deadlift")) exercise  = deadliftExercises;
            else if(workoutType.equals("Squat")) exercise  = squatExercises;
            else exercise  = benchPressExercises;

            trDays.add(new TrainingDay(dayMonth, dayResultsMass, workoutType, exercise));
        }
    }

    public static void fromSetToFile(File f, HashSet<TrainingDay> trDays){
        try(FileWriter fw = new FileWriter(f, false);){
            for(TrainingDay trd : trDays){
                fw.write(trd.toString());
            }
            fw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
